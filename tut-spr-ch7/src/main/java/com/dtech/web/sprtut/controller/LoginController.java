package com.dtech.web.sprtut.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping(value = "hello")
	public String sayHello() {
		return "hello";
	}
}
