package com.dtech.spr.swag.integration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hibernate.annotations.SQLInsert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import com.dtech.spr.swag.entity.User;
import com.dtech.spr.swag.resources.UserBuilder;
import com.dtech.spr.swag.resources.UserResource;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserControllerMVCTest extends IntegrationTest {

	@Autowired
	ObjectMapper mapper;

	@Test
	@Sql(scripts = "classpath:/env/unit-test/test-schema.sql")
	@Sql("classpath:/env/unit-test/test-data.sql")
	public void shouldReturnAllUsers() throws Exception {
		mockMvc.perform(get("/users")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldSaveAndCreateUser() throws Exception {
		// Given
		UserResource userResource = UserBuilder.user().withName("a").withPassword("a").buildUserResource();

		System.out.println(userResource);
		// When
	}
	
	@Test
	public void shouldReturnUserWithGivenId() throws Exception {
		User user = UserBuilder.user().withUsername(faker.name().username()).withPassword(faker.internet().password()).buildUser();
		
		User dbUser = em.merge(user);
		
		mockMvc.perform(get("/users/" + dbUser.getId())).andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.username", equalTo(dbUser.getUserName())))
		.andExpect(jsonPath("$.password", equalTo(dbUser.getPassword())));
	}

	@Test
	public void shouldCreateNewUser() throws Exception {
		// given
		UserResource user = UserBuilder.userResource().withName("AA").withPassword("AA").buildUserResource();

		String writeValueAsString = mapper.writeValueAsString(user);
		mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON_VALUE).content(writeValueAsString))
				.andDo(print());
	}
}
