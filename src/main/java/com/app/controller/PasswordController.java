package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.config.TwilioSmsSender;
import com.app.model.Password;
import com.app.model.User;
import com.app.service.UserService;

@Controller
public class PasswordController {
	@Autowired
	private UserService service;
	@GetMapping("/password")
	public String showForgotPage(Model model) {
		model.addAttribute("password", new Password());
		return "password";
	}

	@PostMapping("/getPwd")
	public String getPassword(@ModelAttribute("password") Password password, Model model) {
		User passwordByUserNumber = service.getPasswordByUserNumber(password.getUserPhoneNumber());
		System.out.println(passwordByUserNumber);
		if(passwordByUserNumber!=null)
		{
			model.addAttribute("msg","Your Password Has Been Sent To Your Registered Mobile Number");
			return "passswordSuccess";
		}
		else {
			model.addAttribute("errMsg","Your Registered Mobile Number Is Incorrect!!");
			return "password";
		}
	
	}
}
