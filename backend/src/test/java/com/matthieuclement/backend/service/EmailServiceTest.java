package com.matthieuclement.backend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.util.ReflectionTestUtils;

import jakarta.mail.Multipart;
import jakarta.mail.Part;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailServiceTest {

    private static String findPart(Object content, String mimeType) throws Exception {
        if (content instanceof Multipart multipart) {
            for (int i = 0; i < multipart.getCount(); i++) {
                Part part = multipart.getBodyPart(i);
                if (part.isMimeType(mimeType))
                    return (String) part.getContent();
                String found = findPart(part.getContent(), mimeType);
                if (found != null)
                    return found;
            }
        }
        return null;
    }

    @Test
    public void testPlainTextAndReplyToAreNotHtmlEscaped() throws Exception {
        JavaMailSender mailSender = mock(JavaMailSender.class);
        when(mailSender.createMimeMessage()).thenAnswer(i -> new JavaMailSenderImpl().createMimeMessage());
        doNothing().when(mailSender).send(any(MimeMessage.class));

        EmailService service = new EmailService(mailSender);
        ReflectionTestUtils.setField(service, "toEmail", "contact@example.com");
        ReflectionTestUtils.setField(service, "platformName", "example.com");

        service.sendMessage("o'brien@example.com", "Tom & Jerry", "Tom & Jerry <3");

        ArgumentCaptor<MimeMessage> captor = ArgumentCaptor.forClass(MimeMessage.class);
        verify(mailSender).send(captor.capture());
        MimeMessage sent = captor.getValue();
        sent.saveChanges();

        assertThat(((InternetAddress) sent.getReplyTo()[0]).getAddress()).isEqualTo("o'brien@example.com");
        assertThat(findPart(sent.getContent(), "text/plain")).contains("Tom & Jerry <3").doesNotContain("&amp;");
        assertThat(findPart(sent.getContent(), "text/html")).contains("Tom &amp; Jerry &lt;3");
    }
}
