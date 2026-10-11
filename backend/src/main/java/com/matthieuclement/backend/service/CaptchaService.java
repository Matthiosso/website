package com.matthieuclement.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.matthieuclement.backend.enums.VerifyResult;

@Service
public class CaptchaService {

    private static final Logger logger = LoggerFactory.getLogger(CaptchaService.class);

    @Value("${friendlycaptcha.api-key}")
    private String apiKey;

    @Value("${friendlycaptcha.site-key}")
    private String sitekey;

    private static final String SITEVERIFY_URL = "https://global.frcapi.com/api/v2/captcha/siteverify";

    private final RestClient restClient = RestClient.create();

    public VerifyResult verify(String captchaResponse) {
        if (captchaResponse == null || captchaResponse.isBlank()) {
            logger.warn("Missing captcha response.");
            return VerifyResult.REJECT;
        }

        try {
            FrcVerifyRequest body = new FrcVerifyRequest(captchaResponse, sitekey);

            FrcVerifyResponse response = restClient.post()
                    .uri(SITEVERIFY_URL)
                    .header("X-API-Key", apiKey)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(body)
                    .retrieve()
                    .body(FrcVerifyResponse.class);

            if (response != null && response.success())
                return VerifyResult.ACCEPT;
            logger.warn("Invalid captcha : {}", response);
            return VerifyResult.REJECT;

        } catch (HttpClientErrorException e) {
            // 4xx: malformed/invalid captcha response or misconfigured API key.
            // Never let the request through in that case.
            logger.error("Friendly Captcha rejected verification request ({}): {}", e.getStatusCode(),
                    e.getResponseBodyAsString());
            return VerifyResult.REJECT;

        } catch (Exception e) {
            // If FriendlyCaptcha is down (5xx, network error), we let user pass according
            // to recommandations in doc.
            logger.warn("Friendly Captcha verification failed: {}", e.getMessage());
            return VerifyResult.ACCEPT_FALLBACK;
        }
    }

    record FrcVerifyRequest(String response, String sitekey) {
    }

    record FrcVerifyResponse(boolean success) {
    }
}
