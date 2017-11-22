package com.dtech.spr.swag.service;

import java.util.List;

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

	public List<UserResource> getAll() {
		List<User> all = userRepository.getAll();
		
		return mapper.mapAsList(all, UserResource.class);
	}

	public UserResource get(Long id) {
		User user = userRepository.get(id);
		return mapper.map(user, UserResource.class);
	}

	public UserResource create(UserResource user) {

		User entity = mapper.map(user, User.class);
		
		UserResource resource = mapper.map(userRepository.create(entity), UserResource.class);
		
		return resource;
	}

	public List<UserResource> update(List<UserResource> users) {
		// TODO to be implemented
		return null;
	}
	
	public List<UserResource> clone(List<UserResource> users) {
		// TODO to be implemented
		return null;
	}
	
	public void delete(Long userId) {
		userRepository.delete(userId);
	}
}
