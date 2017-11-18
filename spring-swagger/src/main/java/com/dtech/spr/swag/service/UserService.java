package com.dtech.spr.swag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtech.spr.swag.repository.UserRepository;
import com.dtech.spr.swag.resources.UserResource;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public UserResource create(UserResource user) {
		UserRepository.
		return new UserResource(user.getName(), user.getPassword());
	}

}
