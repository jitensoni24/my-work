package com.dtech.spr.swag.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name="user_", uniqueConstraints = { @UniqueConstraint(columnNames={"username"}) })
public class User extends Identity {

	private static final long serialVersionUID = 1L;

	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;

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
