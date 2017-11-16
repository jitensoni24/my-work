package com.bskyb.db.builder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bskyb.db.entity.User;
import com.bskyb.db.entity.UserRole;
import com.bskyb.db.resources.UserResource;
import com.bskyb.db.resources.UserRoleResource;

public class UserBuilder {

    private Boolean active;

    private String username;

    private String password;

    private String email;
    
    private String accountType;
	
    private List<UserRoleResource> reourceRoles = new ArrayList<>();
    
    private Set<UserRole> userRoles = new HashSet<>();

    
	private UserBuilder() { }
	
	public static UserBuilder userResource() {
		return new UserBuilder();
	}

	public UserBuilder withActive(Boolean active) {
		this.active = active;
		return this;
	}
	
	public UserBuilder withUserName(String username) {
		this.username = username;
		return this;
	}
	
	public UserBuilder withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public UserBuilder withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public UserBuilder withAccountType(String accountType) {
		this.accountType = accountType;
		return this;
	}

	public UserBuilder withResourceRoles(List<UserRoleResource> roles) {
		this.reourceRoles = roles;
		return this;
	}
	
	public UserBuilder withUserRoles(Set<UserRole> roles) {	
		this.userRoles = roles;
		return this;
	}

	public User buildUser() {
		User user = new User();
		user.setActive(this.active);
		user.setUsername(this.username);
		user.setPassword(this.password);
		user.setEmail(this.email);
		user.setRoles(this.userRoles);
		return user;
	}
	
	public UserResource build() {
		UserResource userResource = new UserResource();
		userResource.setActive(this.active);
		userResource.setUsername(this.username);
		userResource.setPassword(this.password);
		userResource.setEmail(this.email);
		userResource.setRoles(this.reourceRoles);
		userResource.setAccountType(this.accountType);
		
		return userResource;
	}
}
