package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.model.Login;
import com.app.model.User;
import com.app.service.UserService;

@Controller
public class LoginController
{
	@Autowired
	private UserService service;
	@GetMapping("/loginUser")
	public String showLoginPage(Model model)
	{
		Login login=new Login();
		model.addAttribute("login",login);
		return "login";
	}
	
	@PostMapping("/userlogin")
	public String loginUser(@ModelAttribute("login")Login login,Model model)
	{
		User userByEmailAndPassword = service.getUserByEmailAndPassword(login.getUserEmail(),login.getUserPazzword());
		if(userByEmailAndPassword!=null)
		{
			return "successLogin";
		}
		else {
			model.addAttribute("errMsg", "Please Enter Correct Details");
			return "login";
		}
		
	}
}
