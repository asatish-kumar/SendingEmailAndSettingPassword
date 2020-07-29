package com.app.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import com.app.model.Password;
import com.app.model.User;

import freemarker.template.Template;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender emailSender;

	public void sendEmailMessage(User user) throws IOException {

		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setTo(user.getUserEmail());
			helper.setSubject("Unlock Account");
			helper.setText(getunlockUserRegistration(user), true);
		} catch (MessagingException e) {

			e.printStackTrace();
		}

		emailSender.send(message);

	}

	public String getunlockUserRegistration(User acc) throws IOException {
		StringBuffer sb = new StringBuffer();
		FileReader fr = new FileReader("UNLOCK-ACC-BODY-TEMPLATE.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			line = br.readLine();

		}

		br.close();

		String mailbody = sb.toString();

		mailbody = mailbody.replace("{FNAME}", acc.getUserName());
		// mailbody=mailbody.replace("{LNAME}", acc.getLastName());
		mailbody = mailbody.replace("{TEMP-PWD}", acc.getUserPazzword());
		mailbody = mailbody.replace("{EMAIL}", acc.getUserEmail());
		return mailbody;
	}

}
