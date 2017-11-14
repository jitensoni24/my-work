package com.bskyb.db.builder;

import com.bskyb.db.entity.User;
import com.bskyb.db.resources.UserResource;

public class UserBuilder {

	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private UserBuilder() { }
	
	public static UserBuilder aUser() {
		return new UserBuilder();
	}

	public UserBuilder id(Integer id) {
		this.id = id;
		return this;
	}
	
	public UserBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public UserBuilder age(Integer age) {
		this.age = age;
		return this;
	}
	
	public UserResource build() {
		return new UserResource(id, name, age);
	}
}
