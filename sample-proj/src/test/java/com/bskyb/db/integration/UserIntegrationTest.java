package com.bskyb.db.integration;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;



public class UserIntegrationTest extends IntegrationTest {
	
	/**
	 * Get all users test
	 * @throws Exception
	 */
	@Test
	public void shouldReturnUsers() throws Exception {
		mockMvc.perform(get("/users"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$[0].id").value(1))
		.andExpect(jsonPath("$[0].name").value("a"))
		.andExpect(jsonPath("$[0].age").value(20));
	}
	
	@Test
	public void shouldReturnUserWithGivenId() throws Exception {
		mockMvc.perform(get("/users/1"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.name", equalTo("a")))
		.andExpect(jsonPath("$.age", equalTo(20)));
	}
	
	@Test
	public void shouldNotReturnUserWithGivenId() throws Exception {
		mockMvc.perform(get("/users/3"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
}
