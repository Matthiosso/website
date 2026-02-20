package com.matthieuclement.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserMessage {

    @JsonProperty(value = "subject", required = true)
    private String subject;

    @JsonProperty(value = "message", required = true)
    private String message;

    @JsonProperty(value = "userInfo", required = true)
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
