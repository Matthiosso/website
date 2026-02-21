package com.matthieuclement.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthieuclement.backend.entity.UserMessage;
import com.matthieuclement.backend.service.EmailService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/mail")
public class SendMailController {

    private static final Logger logger = LoggerFactory.getLogger(SendMailController.class);

    @Autowired
    private EmailService sendMailService;

    @CrossOrigin(origins = "${settings.cors_origins}")
    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestBody UserMessage userMessage, HttpServletRequest request) {
        logger.info("Received mail send request : {}", userMessage);

        try {
            sendMailService.sendMessage(userMessage.getUserInfo().getUserEmail(), userMessage.getSubject(),
                    userMessage.getMessage());

            logger.info("Email from {} sent successfully.", userMessage.getUserInfo());

        } catch (MailSendException e) {
            logger.error("Failed to send email from {}: {}", userMessage.getUserInfo(), e.getMessage());
            return ResponseEntity.status(500).body("Failed to send email. Please try again later.");
        } catch (MailAuthenticationException e) {
            logger.error("Authentication failed when sending email from {}: {}", userMessage.getUserInfo(),
                    e.getMessage());
            return ResponseEntity.status(500).body("Email authentication failed. Please check server configuration.");
        } catch (MailParseException e) {
            logger.error("Failed to parse email from {}: {}", userMessage.getUserInfo(), e.getMessage());
            return ResponseEntity.status(400).body("Failed to parse email. Please check server configuration.");
        } catch (MailException e) {
            logger.error("General mail error when sending email from {}: {}", userMessage.getUserInfo(),
                    e.getMessage());
            return ResponseEntity.status(500).body("An error occurred while sending message. Please try again later.");
        }
        return ResponseEntity.ok("Message sent successfully.");
    }

}
