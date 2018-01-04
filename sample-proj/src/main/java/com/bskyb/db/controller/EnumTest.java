package com.bskyb.db.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

public class EnumTest {

	@GetMapping("/enumtest")
	public String enumtest(@RequestParam(value="mode") Mode mode) {
		
		System.out.println(mode);
		
		return "simple";
	}
}
