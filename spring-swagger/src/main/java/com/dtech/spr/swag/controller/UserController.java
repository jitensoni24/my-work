package com.dtech.spr.swag.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/users")
	public List<String> getItems() throws Exception {
		List<String> names = new ArrayList<String>();
		names.add("a");
		return names;
	}
}
