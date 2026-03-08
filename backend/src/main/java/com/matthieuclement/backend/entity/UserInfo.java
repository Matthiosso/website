package com.matthieuclement.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserInfo {

    @JsonProperty(value = "userEmail")
    @NotBlank(message = "User email is required")
    @Email(message = "Invalid email format")
    private String userEmail;

    @JsonProperty(value = "userAgent", required = true)
    private String userAgent;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userAgent='" + userAgent + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
