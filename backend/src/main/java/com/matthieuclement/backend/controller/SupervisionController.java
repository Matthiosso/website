package com.matthieuclement.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupervisionController {

    private static final Logger logger = LoggerFactory.getLogger(SupervisionController.class);

    @Value("${application.version}")
    private String applicationVersion;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        logger.info("Checking health");
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/version")
    public ResponseEntity<String> getVersion() {
        return ResponseEntity.ok(applicationVersion);
    }

}