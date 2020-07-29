package com.app.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	private Integer userId;
	private String userName;
	private String userEmail;
	private String userPazzword;
	private String userAccStatus;
	private Date createdDate;
	private Date updatedDate;
	private String userPhoneNumber;
}
