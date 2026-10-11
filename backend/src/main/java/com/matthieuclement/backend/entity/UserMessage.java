package com.matthieuclement.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserMessage {

    @JsonProperty(value = "subject")
    @NotBlank(message = "Subject is required")
    @Size(max = 70, message = "Subject must be less than 70 characters")
    private String subject;

    @JsonProperty(value = "message")
    @NotBlank(message = "Message is required")
    @Size(max = 1000, message = "Message must be less than 1000 characters")
    private String message;

    @JsonProperty(value = "captchaResponse")
    @NotBlank(message = "Captcha response is required")
    private String captchaResponse;

    @JsonProperty(value = "userInfo")
    @NotNull(message = "User info is required")
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

    public String getCaptchaResponse() {
        return captchaResponse;
    }

    public void setCaptchaResponse(String captchaResponse) {
        this.captchaResponse = captchaResponse;
    }

    @Override
    public String toString() {
        // Do not expose user content: this object may end up in logs.
        return "UserMessage{" +
                "subjectLength=" + (subject == null ? 0 : subject.length()) +
                ", messageLength=" + (message == null ? 0 : message.length()) +
                ", userInfo=" + userInfo +
                '}';
    }
}
