package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Password;
import com.app.model.User;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Component
public class TwilioSmsSender implements SmsSender {
	@Autowired
	private TwilioConfiguration configuration;

	@Override
	public void sendSms(User password) {
		if (isPhoneNumberValid(password.getUserPhoneNumber())) {
			PhoneNumber to = new PhoneNumber(password.getUserPhoneNumber());
			PhoneNumber from = new PhoneNumber(configuration.getTrialNumber());
			String userEmail = password.getUserEmail();
			String userPazzword = password.getUserPazzword();
			String message = "Your Email Id And Password is:"+userEmail+ " " +userPazzword  ;
			MessageCreator creator = Message.creator(to, from, message);
			creator.create();
			System.out.println("sms sent");
		} else {
			throw new IllegalArgumentException(
					"Phone number [" + password.getUserPhoneNumber() + "] is not a valid number");
		}

	}
	private boolean isPhoneNumberValid(String phoneNumber) {
		// TODO: Implement phone number validator
		return true;
	}
}
