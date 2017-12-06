package com.bskyb.db.integration;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Set;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import com.bskyb.db.builder.AuthorBuilder;
import com.bskyb.db.builder.BookBuilder;
import com.bskyb.db.entity.Author;
import com.bskyb.db.entity.Book;

public class AuthorIntegrationTest extends IntegrationTest {

	@Test
	public void getAll() throws Exception {
		
		Author author1 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
		Author author2 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
		
		em.merge(author1);
		em.merge(author2);
		
		
		mockMvc.perform(get("/author"))
			.andDo(print())
			.andExpect(status().is(HttpStatus.OK.value()))
			.andExpect(jsonPath("$", hasSize(2)));
	}
	
	@Test
	public void getAllAuthorBooks() throws Exception {
		Author author1 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
		Author author2 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
		/*
		Author expected1 = em.merge(author1);
		Author expected2 = em.merge(author2);*/
		
		Book book1 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.idNumber().hashCode()).authors(Arrays.asList(author1)).build();
		Book book2 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.idNumber().hashCode()).authors(Arrays.asList(author1)).build();
		Book book3 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.idNumber().hashCode()).authors(Arrays.asList(author2)).build();
		
		Author dbAuthor1 = null;
		
		Set<Author> authors_1 = book1.getAuthors();
		for (Author author : authors_1) {
			dbAuthor1 = em.merge(author);
		}
		
		Set<Author> authors_2 = book3.getAuthors();
		for (Author author : authors_2) {
			em.merge(author);
		}
		
		Book merge = em.merge(book1);
		em.merge(book2);
		
		em.flush();
		
		System.out.println(dbAuthor1.getId());
		
		mockMvc.perform(get("/author/book/" + dbAuthor1.getId() ))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	public void getAllAuthorBlogs() throws Exception {
		mockMvc.perform(get("/author/blog/") )
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	public void getAllAuthorPublications() throws Exception {
		mockMvc.perform(get("/author/publications"))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
