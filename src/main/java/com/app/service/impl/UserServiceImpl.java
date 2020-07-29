package com.app.service.impl;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.config.TwilioSmsSender;
import com.app.constants.AppConstants;
import com.app.entity.UserEntity;
import com.app.model.Password;
import com.app.model.User;
import com.app.repo.UserRepository;
import com.app.service.UserService;
import com.app.utils.EmailUtils;
import com.app.utils.PasswordUtils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private EmailUtils emailUtils;
	@Autowired
	private TwilioSmsSender smsSender;
	@Override
	public boolean saveUser(User user) {

		user.setUserPazzword(PasswordUtils.generateTempPwd(AppConstants.TEMP_PWD_LENGTH));
		user.setUserAccStatus(AppConstants.LOCKED_STR);
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		UserEntity savedEntity = repo.save(entity);
		if (savedEntity != null) {

			try {
				emailUtils.sendEmailMessage(user);
			} catch (Exception e) {

				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	@Override
	public String findByEmail(String email) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(email, entity);
		UserEntity findByUserEmail = repo.findByUserEmail(email);
		if (null != findByUserEmail) {
			return "Duplicate";
		}
		return "Unique";
	}

	@Override
	public User getUserByTempPwdAndEmail(String tempPwd, String userEmail) {
		UserEntity entity = repo.findByUserPazzwordAndUserEmail(tempPwd, userEmail);
		User user = null;
		if (entity != null) {
			user = new User();
			BeanUtils.copyProperties(entity, user);
		}
		return user;
	}

	@Override
	public User getUserByEmailAndPassword(String userEmail, String userPazzword) {
		UserEntity entity = repo.findByUserEmailAndUserPazzword(userEmail, userPazzword);
		User user = null;
		if (entity != null) {
			user = new User();
			BeanUtils.copyProperties(entity, user);
		}
		return user;
	}
	@Override
	public User getPasswordByUserNumber(String userPhoneNumber) {
		UserEntity entity=repo.findByUserPhoneNumber(userPhoneNumber);
		User user=null;
		if(entity!=null)
		{
			user=new User();
			BeanUtils.copyProperties(entity, user);
			smsSender.sendSms(user);
		}
		return user;
	}
	@Override
	public boolean updateUser(User u) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(u, entity);
		UserEntity update = repo.save(entity);
		return update != null;
	}
}
