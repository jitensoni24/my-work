package com.dtech.web.sprtut.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	private MockMvc mockMvc;
	
	LoginController loginController;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(new LoginController()).build();
	}

	@Test
	public void testSayHello() throws Exception {
		this.mockMvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(containsString("hello")));
		
		fail("Not yet implemented");
	}

}
