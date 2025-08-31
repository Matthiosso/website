package com.matthieuclement.backend.service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.matthieuclement.backend.exception.FileDownloadException;
import com.matthieuclement.backend.property.FileDownloadProperties;

@Service
public class FileDownloadService {
    private static final Logger logger = LoggerFactory.getLogger(FileDownloadService.class);

    private final Path resumeFileLocationPath;

    public FileDownloadService(FileDownloadProperties fileDownloadProperties) {

        this.resumeFileLocationPath = Paths.get(fileDownloadProperties.getResumeFilepath())
                .toAbsolutePath().normalize();

    }

    public Resource loadFileAsResource() throws FileDownloadException {
        try {
            logger.info("Loading file {} as Resource", resumeFileLocationPath.toString());
            Resource resource = new UrlResource(resumeFileLocationPath.toUri());
            if (resource.exists()) {
                logger.info("The Resource has been sucessfully loaded");
                return resource;
            } else {
                logger.error("Error while trying to load resource");
                throw new FileDownloadException("File not found " + resumeFileLocationPath);
            }
        } catch (MalformedURLException ex) {
            logger.error("Error while trying to load resource, the URL is malformed : {}", ex.getMessage());
            throw new FileDownloadException("File not found " + resumeFileLocationPath, ex);
        }
    }

}