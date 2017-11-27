package com.bskyb.db.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bskyb.db.enums.Type;
import com.bskyb.db.resources.AddressResource;
import com.bskyb.db.resources.UserResource;
import com.bskyb.db.resources.UserRoleResource;
import com.github.javafaker.Faker;

public class UserResourceBuilder {

	public static final Faker fake = Faker.instance();

	private Long id;
	
    private String username;

    private String password;

    private List<UserRoleResource> reourceRoles = new ArrayList<>();

    private List<AddressResource> address = new ArrayList<>();

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
	
	public UserResourceBuilder withAddress() {
		this.address = Arrays.asList(new AddressResource(Type.HOME, fake.address().streetAddress(), fake.address().city()));
		return this;
	}
	
	public UserResourceBuilder withResourceRoles() {
		this.reourceRoles = Arrays.asList(new UserRoleResource(fake.lorem().word()), new UserRoleResource(fake.lorem().word()));;
		return this;
	}
	
	
	public UserResource build() {
		UserResource userResource = new UserResource();
		userResource.setId(this.id);
		userResource.setUsername(this.username);
		userResource.setPassword(this.password);
		userResource.setRoles(this.reourceRoles);
		userResource.setAddress(this.address);
		
		return userResource;
	}
}
