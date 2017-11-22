package com.bskyb.db.integration;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.bskyb.db.builder.UserBuilder;
import com.bskyb.db.builder.UserResourceBuilder;
import com.bskyb.db.entity.User;
import com.bskyb.db.resources.UserResource;

public class UserIntegrationTest extends IntegrationTest {
	
	@Test
	public void shouldReturnUsersFromTestDataScripts() throws Exception {
		// when and then
		mockMvc.perform(get("/users"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
		.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("$[0].id", equalTo(1)))
        .andExpect(jsonPath("$[0].username", equalTo("NAME-1")))
        .andExpect(jsonPath("$[0].password").doesNotExist())
        .andExpect(jsonPath("$[0].roles.length()", equalTo(1)))
        .andExpect(jsonPath("$[0].roles[0].role", equalTo("ROLE-1")));
	}
		
	
	/**
	 * Get all users test
	 * @throws Exception
	 */
	@Test
	public void shouldAddAndReturnAllUsers() throws Exception {
		// Given
		List<String> roles = Arrays.asList(fake.lorem().word(), fake.lorem().word());
		
		System.out.println(roles);
		
		User expectedUser = UserBuilder.user()
				.withUserName(fake.name().name()).withPassword(fake.internet().password())
				.withUserRoles(roles).buildUser();
		
        em.merge(expectedUser);

        // when and then
		mockMvc.perform(get("/users"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
		.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("$[0].id", equalTo(1)))
        .andExpect(jsonPath("$[0].username", equalTo("NAME-1")))
        .andExpect(jsonPath("$[0].password").doesNotExist())
        .andExpect(jsonPath("$[0].roles.length()", equalTo(1)))
        .andExpect(jsonPath("$[0].roles[0].role", equalTo("ROLE-1")));
	}
	
	
    @Test
    public void shouldCreateUser() throws Exception {
    	// given
    	List<String> roles = Arrays.asList(fake.lorem().word(), fake.lorem().word());
		
    	System.out.println(roles);
		
		UserResource userResource = UserResourceBuilder.userResource()
				.withUserName(fake.name().name()).withPassword(fake.internet().password())
				.withResourceRoles(roles).build();
		
        String jsonPayload = getJsonPayload(userResource);

        // when and then
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonPayload))
		.andDo(print())
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.username", equalTo(userResource.getUsername())))
        .andExpect(jsonPath("$.password").doesNotExist())
        .andExpect(jsonPath("$.roles.length()", equalTo(2)))
        .andExpect(jsonPath("$.roles[0].role", equalTo(roles.get(0))));
    }
	
	/*
	@Test
	public void shouldReturnUserWithGivenId() throws Exception {
		mockMvc.perform(get("/users/1"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.username", equalTo("a")))
		.andExpect(jsonPath("$.password", equalTo(20)));
	}
	
	@Test
	public void shouldNotReturnUserWithGivenId() throws Exception {
		mockMvc.perform(get("/users/3"))
		.andDo(print())
		.andExpect(status().isOk());
	}*/


}
