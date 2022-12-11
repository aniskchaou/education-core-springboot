package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.UserRepository;
@Service
public class UserDTO implements DTO {

	@Autowired
	UserRepository  userRepository;
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub
		user.setPassword("admin");
		user.setRole(role);
		user.setUsername("admin");
		userRepository.save(user);
	}

}
