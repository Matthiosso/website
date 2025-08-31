package com.matthieuclement.backend.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileDownloadProperties {
    private String resumeFilepath;

    public String getResumeFilepath() {
        return resumeFilepath;
    }

    public void setResumeFilepath(String resumeFilepath) {
        this.resumeFilepath = resumeFilepath;
    }
}
