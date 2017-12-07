package com.bskyb.db.integration;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import com.bskyb.db.entity.Author;

public class AuthorIntegrationTest extends IntegrationTest {

	@Test
	public void getAll() throws Exception {
		
		mockMvc.perform(get("/author"))
			.andDo(print())
			.andExpect(status().is(HttpStatus.OK.value()))
			.andExpect(jsonPath("$", hasSize(2)));
	}
	
	@Test
	public void getAllAuthorBooks() throws Exception {
		Author a1 = em.find(Author.class, 1L);
		System.out.println(a1.getName());
		System.out.println(a1.getId());
		
		mockMvc.perform(get("/author/book/" + a1.getId() ))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].pages").exists());
	}
	
	@Test
	public void getAllAuthorBlogs() throws Exception {
		Author a1 = em.find(Author.class, 3L);
		System.out.println(a1.getName());
		System.out.println(a1.getId());
		
		mockMvc.perform(get("/author/blog/" + a1.getId()) )
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].url").exists());
	}
	
	@Ignore
	@Test
	public void getAllAuthorPublications() throws Exception {
		mockMvc.perform(get("/author/publications"))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
