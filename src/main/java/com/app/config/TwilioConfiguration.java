package com.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class TwilioConfiguration {
	@Value("${twilio.account_sid}")
	private String accountSid;
	@Value("${twilio.auth_token}")
	private String authToken;
	@Value("${twilio.trial_number}")
	private String trialNumber;

}
