package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.User;
import com.app.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping("/show")
	private String showPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "index";
	}

	@GetMapping("/validateEmail")
	@ResponseBody
	public String validateEmail(@RequestParam("userEmail") String email) {

		String emailStatus = service.findByEmail(email);
		return emailStatus;

	}

	@RequestMapping("/userAccReg")
	private String saveUser(@ModelAttribute("user") User user, Model model) {
		boolean saveUser = service.saveUser(user);
		if (saveUser) {
			model.addAttribute("msg", "User Saved Successfully");
			model.addAttribute("user", new User());
		} else {
			model.addAttribute("errMsg", "User Not Saved");
		}
		return "success";
	}

}
