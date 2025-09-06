package com.matthieuclement.backend.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FileDownloadControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testGetResumeFile() throws Exception {
        ResponseEntity<Resource> response = template.getForEntity("/download/resume", Resource.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(response.getBody().getFilename().equals("resume.pdf"));
    }
}