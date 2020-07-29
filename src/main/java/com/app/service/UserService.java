package com.app.service;

import com.app.model.User;

public interface UserService {
	public boolean saveUser(User u);
	public String findByEmail(String email);
	public User getUserByTempPwdAndEmail(String tempPwd,String userEmail);
	public boolean updateUser(User u);
	public User getUserByEmailAndPassword(String userEmail,String userPazzword);
	public User getPasswordByUserNumber(String userPhoneNumber);
}
