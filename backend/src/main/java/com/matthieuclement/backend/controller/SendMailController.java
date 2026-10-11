package com.matthieuclement.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthieuclement.backend.entity.UserMessage;
import com.matthieuclement.backend.enums.VerifyResult;
import com.matthieuclement.backend.service.CaptchaService;
import com.matthieuclement.backend.service.EmailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mail")
public class SendMailController {

    private static final Logger logger = LoggerFactory.getLogger(SendMailController.class);

    @Autowired
    private EmailService sendMailService;

    @Autowired
    private CaptchaService captchaService;

    @CrossOrigin(origins = "${settings.cors_origins}")
    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@Valid @RequestBody UserMessage userMessage, BindingResult bindingResult) {
        logger.info("Received mail send request.");

        if (bindingResult.hasErrors()) {
            // Only log field names: rejected values may contain personal data.
            logger.warn("Validation errors found in UserMessage on fields: {}",
                    bindingResult.getFieldErrors().stream().map(FieldError::getField).toList());
            return ResponseEntity.badRequest().body("Validation errors found in the submitted message.");
        }

        if (captchaService.verify(userMessage.getCaptchaResponse()) == VerifyResult.REJECT) {
            logger.warn("Invalid captcha.");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid captcha.");
        }

        try {
            sendMailService.sendMessage(
                    userMessage.getUserInfo().getUserEmail(),
                    userMessage.getSubject(),
                    userMessage.getMessage());

            logger.info("Email sent successfully.");
            return ResponseEntity.ok("Message sent successfully.");

        } catch (MailException e) {
            logger.error("Failed to send email.", e);
            return ResponseEntity.internalServerError()
                    .body("An error occurred while sending message. Please try again later.");
        }
    }

}
