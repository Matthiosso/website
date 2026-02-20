package com.matthieuclement.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {

    @JsonProperty(value = "userEmail", required = true)
    private String userEmail;

    @JsonProperty(value = "userAgent", required = true)
    private String userAgent;

    @JsonProperty(value = "gaClientId", required = true)
    private String googleClientId;

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

    public String getGoogleClientId() {
        return googleClientId;
    }

    public void setGoogleClientId(String googleClientId) {
        this.googleClientId = googleClientId;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userAgent='" + userAgent + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", googleClientId='" + googleClientId + '\'' +
                '}';
    }
}
