package com.dtech.spr.swag.resources;

public class UserBuilder implements Builder<User> {
	private String name;
	private Integer age;
	
	private UserBuilder() {}
	
	public static UserBuilder user() {
		return new UserBuilder();
	}
	
	public User build() {
		return new User(this.name, this.age);
	}
	
	public UserBuilder withName(String name) {
		this.name = name;
		return this;
	}
	public UserBuilder withAge(Integer age) {
		this.age = age;
		return this;
	}

}
