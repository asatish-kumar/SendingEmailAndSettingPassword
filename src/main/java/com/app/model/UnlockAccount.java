package com.app.model;

import lombok.Data;

@Data
public class UnlockAccount {
	private String userEmail;
	private String tempPwd;
	private String newPwd;
	private String confirmPwd;
}
