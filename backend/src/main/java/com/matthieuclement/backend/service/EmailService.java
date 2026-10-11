package com.matthieuclement.backend.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailPreparationException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.util.HtmlUtils;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;

    @Value("${contact.email}")
    private String toEmail;

    @Value("${contact.url}")
    private String platformName;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    private String loadTemplate() throws IOException {
        ClassPathResource resource = new ClassPathResource("mail/contact-template.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    public void sendMessage(String fromEmail, String subject, String message) throws MailException {
        try {
            String rawFromEmail = fromEmail == null ? "" : fromEmail;
            String rawMessage = message == null ? "" : message;
            String rawPlatformName = platformName == null ? "" : platformName;
            String rawSubject = (subject == null ? "" : subject).replaceAll("[\r\n\t]", " ");

            // HTML-escaped values are only meant for the HTML template.
            String safeSubject = HtmlUtils.htmlEscape(rawSubject);
            String safeMessage = HtmlUtils.htmlEscape(rawMessage);
            String safeFromEmail = HtmlUtils.htmlEscape(rawFromEmail);
            String safePlatformName = HtmlUtils.htmlEscape(rawPlatformName);

            String template = loadTemplate();
            String htmlBody = template.replace("{{fromEmail}}", safeFromEmail)
                    .replace("{{subject}}", safeSubject)
                    .replace("{{message}}", safeMessage)
                    .replace("{{platformName}}", safePlatformName);

            String textBody = String.format("You have received a new message from %s (%s):\n\nSubject: %s\n\n%s",
                    rawFromEmail, rawPlatformName, rawSubject, rawMessage);

            var mimeMessage = mailSender.createMimeMessage();
            var helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED,
                    StandardCharsets.UTF_8.name());
            helper.setTo(toEmail);
            helper.setFrom(new InternetAddress(toEmail, "Contact Form"));
            helper.setReplyTo(rawFromEmail);
            helper.setSubject("[Contact] - " + rawSubject);
            helper.setText(textBody, htmlBody);

            logger.info("Sending HTML email from {} with subject '{}'", fromEmail, subject);
            mailSender.send(mimeMessage);

        } catch (IOException e) {
            logger.error("Failed to load HTML email template", e);
            throw new MailPreparationException("Failed to load email template", e);
        } catch (MessagingException e) {
            logger.error("Failed to prepare MIME email message", e);
            throw new MailPreparationException("Failed to prepare email message", e);
        }
    }
}
