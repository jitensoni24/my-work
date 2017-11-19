package com.dtech.spr.swag.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResource {

	
	private Long id;
	
	@JsonProperty("username")
	@JsonInclude(value = Include.NON_NULL)
	private String userName;
	

	@JsonProperty("password")
	@JsonInclude(value = Include.NON_NULL)
	private String password;
	
	public UserResource() {
	}

	public UserResource(String name, String password) {
		this.userName = name;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
