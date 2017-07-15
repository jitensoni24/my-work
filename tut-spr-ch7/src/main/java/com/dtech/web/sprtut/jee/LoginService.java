package com.dtech.web.sprtut.jee;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("test-user") && password.equals("test-password");
	}

}