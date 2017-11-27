package com.bskyb.db.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bskyb.db.entity.Address;
import com.bskyb.db.entity.User;
import com.bskyb.db.entity.UserRole;
import com.bskyb.db.enums.Type;
import com.github.javafaker.Faker;

public class UserBuilder {
	public static final Faker fake = Faker.instance();

    private String username;

    private String password;

    private Set<UserRole> userRoles = new HashSet<>();

    private List<Address> address = new ArrayList<>();
    
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
	
	public UserBuilder withUserRoles() {	
		this.userRoles = new HashSet<>(Arrays.asList(new UserRole(fake.lorem().word()), new UserRole(fake.lorem().word())));
		return this;
	}
	
	public UserBuilder withAddress() {
		this.address = Arrays.asList(new Address(Type.HOME, fake.address().streetAddress(), fake.address().city()));
		return this;
	}

	public User buildUser() {
		User user = new User();
		user.setUsername(this.username);
		user.setPassword(this.password);
		user.setRoles(this.userRoles);
		user.setAddress(this.address);
		return user;
	}	
}
