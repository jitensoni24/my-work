package com.dtech.spr.swag.resources;

import com.dtech.spr.swag.entity.User;

public class UserBuilder {
	
	private String name;
	private String username;
	private String password;
	
	private UserBuilder() {}
	
	public static UserBuilder user() {
		return new UserBuilder();
	}

	public static UserBuilder userResource() {
		return new UserBuilder();
	}
	
	public User buildUser() {
		User user = new User();
		user.setUserName(this.username);
		user.setPassword(this.password);
		return user;
	}
	
	public UserResource buildUserResource() {
		return new UserResource(this.name, this.password);
	}
	
	public UserBuilder withName(String name) {
		this.name = name;
		return this;
	}
	public UserBuilder withUsername(String username) {
		this.username = username;
		return this;
	}
	public UserBuilder withPassword(String password) {
		this.password = password;
		return this;
	}


}
