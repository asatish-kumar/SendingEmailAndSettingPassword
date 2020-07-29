package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.UnlockAccount;
import com.app.model.User;
import com.app.service.UserService;

@Controller
public class UnlockAccountController {
	@Autowired
	private UserService service;

	@GetMapping("/unlockAcc")
	public String unlockAccounForm(@RequestParam("userEmail") String userEmail, Model model) {
		UnlockAccount account = new UnlockAccount();
		account.setUserEmail(userEmail);
		model.addAttribute("account", account);
		return "unlock";

	}

	@PostMapping("/unlock")
	public String unlockAccount(@ModelAttribute("account") UnlockAccount account, Model model) {
		System.out.println(account);
		System.out.println(account.getTempPwd());
		System.out.println(account.getUserEmail());
		User user = service.getUserByTempPwdAndEmail(account.getTempPwd(),account.getUserEmail());
		if (user != null) {
			user.setUserAccStatus("Un-Locked");
			System.out.print(user.getUserAccStatus());
			user.setUserPazzword(account.getNewPwd());
			System.out.println(user.getUserPazzword());
			boolean updateUser = service.updateUser(user);
			if (updateUser) {
				return "unlockSuccess";
			}
		}
		model.addAttribute("errMsg", "Please Enter Correct Tempory Password");
		return "unlock";
	}

}
