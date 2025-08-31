package com.matthieuclement.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FileDownloadException extends ResponseStatusException {
    public FileDownloadException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public FileDownloadException(String message, Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message, cause);
    }
}