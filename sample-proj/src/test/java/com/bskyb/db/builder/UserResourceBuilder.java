package com.bskyb.db.builder;

import java.util.ArrayList;
import java.util.List;

import com.bskyb.db.resources.UserResource;
import com.bskyb.db.resources.UserRoleResource;

public class UserResourceBuilder {

	private Long id;
	
    private String username;

    private String password;

    private List<UserRoleResource> reourceRoles = new ArrayList<>();
    
	private UserResourceBuilder() { }
	
	public static UserResourceBuilder userResource() {
		return new UserResourceBuilder();
	}

	public UserResourceBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public UserResourceBuilder withUserName(String username) {
		this.username = username;
		return this;
	}
	
	public UserResourceBuilder withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public UserResourceBuilder withResourceRoles(List<String> roles) {
		
		List<UserRoleResource> userRoles = new ArrayList<>();
		for (String string : roles) {
			UserRoleResource role = new UserRoleResource(string);
			userRoles.add(role);
		}
		this.reourceRoles = userRoles;
		return this;
	}
	
	
	public UserResource build() {
		UserResource userResource = new UserResource();
		userResource.setId(this.id);
		userResource.setUsername(this.username);
		userResource.setPassword(this.password);
		userResource.setRoles(this.reourceRoles);
		
		return userResource;
	}
}
