package com.matthieuclement.backend.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

@SpringBootTest
public class FileDownloadServiceTest {

    @Autowired
    private FileDownloadService fileDownloadService;

    @Test
    public void testLoadFileAsResource() throws IOException {
        Resource res = fileDownloadService.loadFileAsResource();
        assertThat(res.exists());
    }
}