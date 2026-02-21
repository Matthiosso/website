package com.matthieuclement.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserMessage {

    @JsonProperty(value = "subject")
    @NotBlank(message = "Subject is required")
    @Size(max = 70, message = "Subject must be less than 70 characters")
    private String subject;

    @JsonProperty(value = "message")
    @NotBlank(message = "Message is required")
    @Size(max = 500, message = "Message must be less than 500 characters")
    private String message;

    @JsonProperty(value = "userInfo")
    @Valid
    private UserInfo userInfo;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
