package com.dtech.web.sprtut.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dtech.web.sprtut.jee.LoginService;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	private static final String TEST_PASSWORD = "test-password";

	private static final String TEST_USER = "test-user";

	@Mock
	LoginService loginService;
	
	private MockMvc mockMvc;
	
	@InjectMocks
	LoginController loginController = new LoginController();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}

	@Test
	public void testSayHello() throws Exception {
		this.mockMvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(containsString("hello")));
		
		fail("Not yet implemented");
	}
	
	@Test
	public void testLogin_page() throws Exception {
		mockMvc.perform(get("/login"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(""));
	}

	
	@Test
	public void testLogin_validate() throws Exception {
		//when
		when(loginService.validateUser(TEST_USER,TEST_PASSWORD)).thenReturn(true);
		
		mockMvc.perform(post("/login")
				.param("username", TEST_USER)
				.param("password", TEST_PASSWORD))
			.andDo(print())
			.andExpect(status().isOk());
		
		verify(loginService, times(1)).validateUser(TEST_USER, TEST_PASSWORD);
	}
}
