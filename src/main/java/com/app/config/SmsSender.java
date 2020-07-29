package com.app.config;

import com.app.model.User;

public interface SmsSender {
	public void sendSms(User password);
}
