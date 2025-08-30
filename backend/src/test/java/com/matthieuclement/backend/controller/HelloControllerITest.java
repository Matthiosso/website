package com.matthieuclement.backend.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerITest {

	@Autowired
	private TestRestTemplate template;

    @Test
    public void getIndex() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/", String.class);
        assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/hello", String.class);
        assertThat(response.getBody()).isEqualTo("Hello World!");
    }

    @Test
    public void getHelloWithParam() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/hello?name=toto", String.class);
        assertThat(response.getBody()).isEqualTo("Hello toto!");
    }
}