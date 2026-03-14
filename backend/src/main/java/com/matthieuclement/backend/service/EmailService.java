package com.matthieuclement.backend.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.util.HtmlUtils;

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
            String safeSubject = HtmlUtils.htmlEscape(subject == null ? "" : subject);
            String safeMessage = HtmlUtils.htmlEscape(message == null ? "" : message);
            String safeFromEmail = HtmlUtils.htmlEscape(fromEmail == null ? "" : fromEmail);
            String safePlatformName = HtmlUtils.htmlEscape(platformName == null ? "" : platformName);

            String template = loadTemplate();
            String htmlBody = template.replace("{{fromEmail}}", safeFromEmail)
                    .replace("{{subject}}", safeSubject)
                    .replace("{{message}}", safeMessage)
                    .replace("{{platformName}}", safePlatformName);

            var mimeMessage = mailSender.createMimeMessage();
            var helper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
            helper.setTo(toEmail);
            helper.setFrom(toEmail);
            helper.setSubject("[" + safePlatformName + "] - " + safeSubject);
            helper.setText(htmlBody, true);

            logger.info("Sending HTML email from {} with subject '{}'", fromEmail, subject);
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.error("Failed to compose or send HTML email", e);
            throw new MailException("Failed to send email") {
                private static final long serialVersionUID = 1L;
            };
        }
    }
}
