package com.dtech.web.sprtut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtech.web.sprtut.jee.LoginService;

@Controller
public class LoginController {

	private static final String WELCOME = "welcome";
	private static final String LOGIN = "login";
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "hello")
	@ResponseBody
	public String sayHello() {
		return "hello";
	}

	@RequestMapping(value = LOGIN, method=RequestMethod.GET) 
	public String login() throws Exception {
		return LOGIN;
	}
	
	@RequestMapping(value = LOGIN, method=RequestMethod.POST) 
	public String loginAction(@RequestParam("username") String userName, 
			@RequestParam("password") String password) throws Exception {

		System.out.println(loginService);
		if( !loginService.validateUser(userName, password) ) {
			return LOGIN;
		}
		
		return WELCOME;
	}
}
