package com.app.utils;

import java.security.SecureRandom;

public class PasswordUtils {
	private static final String ALPHA_NUMERIC_STRING="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static String generateTempPwd(int count)
	{
		SecureRandom random = new SecureRandom();
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < count; i++) {
			int randomIndex = random.nextInt(ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(randomIndex));
		}

		return builder.toString();
	}

	
}
