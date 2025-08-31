package com.matthieuclement.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupervisionController {

    private static final Logger logger = LoggerFactory.getLogger(SupervisionController.class);

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        logger.info("Checking health");
        return ResponseEntity.ok("OK");
    }
}