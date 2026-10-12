package com.matthieuclement.backend.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SendMailControllerTest {

    @Autowired
    private TestRestTemplate template;

    private ResponseEntity<String> post(String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return template.postForEntity("/mail/send", new HttpEntity<>(json, headers), String.class);
    }

    @Test
    public void testMissingUserInfoReturnsBadRequest() throws Exception {
        ResponseEntity<String> response = post("{\"subject\":\"a\",\"message\":\"b\",\"captchaResponse\":\"x\"}");
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(400));
    }

    @Test
    public void testMissingCaptchaReturnsBadRequest() throws Exception {
        ResponseEntity<String> response = post(
                "{\"subject\":\"a\",\"message\":\"b\",\"userInfo\":{\"userEmail\":\"a@b.com\",\"userAgent\":\"ua\"}}");
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(400));
    }
}
