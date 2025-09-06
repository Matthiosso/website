package com.matthieuclement.backend.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "file.resume-filepath=./src/test/resources/fake-file.txt"
})
public class FileDownloadServiceTest {

    @Autowired
    private FileDownloadService fileDownloadService;

    @Test
    public void testLoadFileAsResource() throws IOException {
        Resource res = fileDownloadService.loadFileAsResource();
        assertThat(res.exists());
        assertThat(res.getFilename().equals("fake-file.txt"));
        assertThat(res.getContentAsString(StandardCharsets.UTF_8).equals("Test"));
    }
}