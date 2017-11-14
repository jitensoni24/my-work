package com.dtech.spr.swag;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

import com.dtech.spr.swag.resources.User;
import com.dtech.spr.swag.resources.UserBuilder;

public class UserControllerMVCTest extends IntegrationTest {
	
	
	@Test
	public void shouldReturnAllUsers() throws Exception {
		mockMvc.perform(get("/users"))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	public void shouldSaveAndCreateUser() throws Exception {
		//Given
		User user = UserBuilder.user().withName("a").withAge(1).build();
		
		
		//When
		
		
		
	}
}
