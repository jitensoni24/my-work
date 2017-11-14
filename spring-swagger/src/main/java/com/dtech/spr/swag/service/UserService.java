package com.dtech.spr.swag.service;

import org.springframework.stereotype.Service;

import com.dtech.spr.swag.resources.User;

@Service
public class UserService {

	public User create(User user) {
		System.out.println("done");
		
		return new User(user.getName(), user.getAge());
	}

}
