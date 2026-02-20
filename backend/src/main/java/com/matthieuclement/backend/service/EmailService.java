package com.matthieuclement.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;

    @Value("${contact.email}")
    private String toEmail;

    @Value("${contact.prefix}")
    private String emailSubjectPrefix;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMessage(String fromEmail, String subject, String message) throws MailException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setFrom(toEmail);
        mailMessage.setSubject(emailSubjectPrefix + subject);
        mailMessage.setText("Content: '" + message + "'\n\nFrom: " + fromEmail);
        logger.info("Sending plain text email: {}", mailMessage);
        mailSender.send(mailMessage);
    }
}
