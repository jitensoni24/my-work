package com.dtech.spr.swag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtech.spr.swag.entity.User;
import com.dtech.spr.swag.mapper.OrikaBeanMapper;
import com.dtech.spr.swag.repository.UserRepository;
import com.dtech.spr.swag.resources.UserResource;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	OrikaBeanMapper mapper;
	
	public UserResource create(UserResource user) {

		User entity = mapper.map(user, User.class);
		
		UserResource resource = mapper.map(userRepository.create(entity), UserResource.class);
		
		return resource;
	}

	public UserResource get(Long id) {
		User user = userRepository.get(id);
		return mapper.map(user, UserResource.class);
	}

}
