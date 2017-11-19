package com.dtech.spr.swag.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dtech.spr.swag.resources.UserResource;
import com.dtech.spr.swag.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<UserResource> getUsers() throws Exception {
		List<UserResource> names = Arrays.asList(new UserResource("a", "a"), new UserResource("b", "a"));
		return names;
	}

	@GetMapping("/users/{id}")
	public UserResource getUser(@PathVariable Long id) throws Exception {
		UserResource resource = userService.get(id);
		return resource;
	}
	
	
	@PostMapping("/users")
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserResource postUser(@RequestBody UserResource user) throws Exception {
		System.out.println("user: " + user);
		return userService.create(user);
	}

	
	@PutMapping("/users")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void postUsers(List<UserResource> users) throws Exception {
		System.out.println("users: " + users);
	}
	
}
