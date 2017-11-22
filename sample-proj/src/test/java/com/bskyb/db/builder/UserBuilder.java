package com.bskyb.db.builder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bskyb.db.entity.User;
import com.bskyb.db.entity.UserRole;

public class UserBuilder {

    private String username;

    private String password;

    private Set<UserRole> userRoles = new HashSet<>();

	private UserBuilder() { }
	
	public static UserBuilder user() {
		return new UserBuilder();
	}
	
	public UserBuilder withUserName(String username) {
		this.username = username;
		return this;
	}
	
	public UserBuilder withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public UserBuilder withUserRoles(List<String> roles) {	
		Set<UserRole> userRoles = new HashSet<>();
		for (String string : roles) {
			UserRole role = new UserRole(string);
			userRoles.add(role);
		}
		this.userRoles = userRoles;
		return this;
	}

	public User buildUser() {
		User user = new User();
		user.setUsername(this.username);
		user.setPassword(this.password);
		user.setRoles(this.userRoles);
		return user;
	}	
}
