package com.bskyb.db.integration;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.bskyb.db.builder.UserBuilder;
import com.bskyb.db.entity.User;
import com.bskyb.db.entity.UserRole;
import com.bskyb.db.resources.UserResource;
import com.bskyb.db.resources.UserRoleResource;

public class UserIntegrationTest extends IntegrationTest {
	
	/**
	 * Get all users test
	 * @throws Exception
	 */
	@Test
	public void shouldReturnUsers() throws Exception {
		// Given
		Set<UserRole> userRoles = new HashSet<>();
		UserRole role = new UserRole(fake.lorem().word());
		userRoles.add(role);
		
		User expectedUser = UserBuilder.userResource()
				.withActive(true).withUserName(fake.name().name()).withPassword(fake.internet().password())
				.withEmail(fake.internet().emailAddress()).withAccountType(fake.lorem().word())
				.withUserRoles(userRoles).buildUser();
		
        User user = em.merge(expectedUser);
		
		mockMvc.perform(get("/users"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
		.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("$[0].id", equalTo(user.getId().toString())))
        .andExpect(jsonPath("$[0].active", equalTo(user.getActive())))
        .andExpect(jsonPath("$[0].username", equalTo(user.getUsername())))
        .andExpect(jsonPath("$[0].email", equalTo(user.getEmail())))
        .andExpect(jsonPath("$[0].password").doesNotExist())
        .andExpect(jsonPath("$[0].accountType", equalTo("")))
        .andExpect(jsonPath("$[0].roles.length()", equalTo(1)))
        .andExpect(jsonPath("$[0].roles[0].role", equalTo(role.getRole())));
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


    @Test
    public void shouldCreateUser() throws Exception {
    	// given
		List<UserRoleResource> userRoles = new ArrayList<>();
		UserRoleResource userRoleResource = new UserRoleResource(fake.lorem().word());
		userRoles.add(userRoleResource);
		
		UserResource userResource = UserBuilder.userResource()
				.withActive(true).withUserName(fake.name().name()).withPassword(fake.internet().password())
				.withEmail(fake.internet().emailAddress()).withAccountType(fake.lorem().word())
				.withResourceRoles(userRoles).build();
		
        String jsonPayload = getJsonPayload(userResource);

        // When
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonPayload))
		.andDo(print())
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.active", equalTo(userResource.getActive())))
        .andExpect(jsonPath("$.username", equalTo(userResource.getUsername())))
        .andExpect(jsonPath("$.email", equalTo(userResource.getEmail())))
        .andExpect(jsonPath("$.password").doesNotExist())
        .andExpect(jsonPath("$.roles.length()", equalTo(1)))
        .andExpect(jsonPath("$.roles[0].role", equalTo(userRoleResource.getRole())));
    }
}
