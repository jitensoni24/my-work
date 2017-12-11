package com.bskyb.db.integration;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;

public class AuthorIntegrationTest extends IntegrationTest {

	@Test
	public void getAll() throws Exception {
		
		mockMvc.perform(get("/author"))
			.andDo(print())
			.andExpect(status().is(HttpStatus.OK.value()))
			.andExpect(jsonPath("$", hasSize(7)));
	}
	
	@Test
	public void getAllAuthorBooks() throws Exception {
		
		System.out.println(author.getId());
		System.out.println(author.getName());
		
		mockMvc.perform(get("/author/book/" + author.getId() ))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].pages").exists());
	}
	
	@Test
	public void getAllAuthorBlogs() throws Exception {
		System.out.println(author.getName());
		System.out.println(author.getId());
		
		mockMvc.perform(get("/author/blog/" + author.getId()) )
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].url").exists());
	}
	
	@Test
	public void getBookWithMaxPages() throws Exception {
		
		mockMvc.perform(get("/author/book/max/pages"))
			.andDo(print())
			.andExpect(status().is(HttpStatus.OK.value()))
			.andExpect(jsonPath("$.size()", greaterThanOrEqualTo(1)));
	}
	
	@Ignore
	@Test
	public void getAllAuthorPublications() throws Exception {
		mockMvc.perform(get("/author/publications"))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
