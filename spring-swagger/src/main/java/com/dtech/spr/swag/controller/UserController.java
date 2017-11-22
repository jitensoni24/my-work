package com.dtech.spr.swag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		return userService.getAll();
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
	public List<UserResource> postUsers(List<UserResource> users) throws Exception {
		return userService.update(users);
	}
	
	@DeleteMapping("/users/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteUser(@PathVariable Long id) throws Exception {
		userService.delete(id);
	}
}
