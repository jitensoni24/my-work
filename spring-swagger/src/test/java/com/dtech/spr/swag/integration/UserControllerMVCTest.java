package com.dtech.spr.swag.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

import com.dtech.spr.swag.resources.UserResource;
import com.dtech.spr.swag.entity.User;
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
		UserResource userResource = UserBuilder.user().withName("a").withPassword("a").buildUserResource();
		
		
		//When
		
		
		
	}
	
	@Test
	public void shouldCreateNewUser() throws Exception {
		// given
		User user = UserBuilder.user().withName("AA").withPassword("AA").buildUser();
	}
}
