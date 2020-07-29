package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
	public UserEntity findByUserEmail(String email); 
	public UserEntity findByUserPazzwordAndUserEmail(String tempPwd,String userEmail);
	public UserEntity findByUserEmailAndUserPazzword(String userEmail,String userPazzword);
	public UserEntity findByUserPhoneNumber(String userPhoneNumber);
}

