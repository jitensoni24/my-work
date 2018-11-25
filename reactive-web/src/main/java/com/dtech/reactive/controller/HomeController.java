package com.dtech.reactive.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtech.reactive.repository.CoffeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	CoffeeRepository repository;

	ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) throws JsonProcessingException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		
		String writeValueAsString = mapper.writeValueAsString("date" + ":" + formattedDate);
		
		return writeValueAsString;
	}
	
	@GetMapping(value = "/coffee")
	public String getAll() throws JsonProcessingException {
		
		return mapper.writeValueAsString(repository.get("latte-1"));
	}
	
	
}
