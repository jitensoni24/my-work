package com.bskyb.db.integration;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.bskyb.db.build.AuthorBuilder;
import com.bskyb.db.build.BookBuilder;
import com.bskyb.db.config.ApplicationConfig;
import com.bskyb.db.entity.Author;
import com.bskyb.db.entity.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

@ActiveProfiles("unit-test")
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback
@Transactional
@WebAppConfiguration
@ContextConfiguration(classes = { ApplicationConfig.class })
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public abstract class IntegrationTest {

    @PersistenceContext
    protected EntityManager em;
	
	private static final Logger LOGGER = LogManager.getLogger();

	public static final Faker fake = Faker.instance();

	@Autowired
	protected WebApplicationContext wac;
	
	protected MockMvc mockMvc;

	@Autowired 
	ObjectMapper mapper;
	
	@Before
	public void init() throws Exception {
		 mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		 
		 dataInit();
	}
	
	@Test
	public void testSpringContextConfiguration() throws Exception {
		
		LOGGER.info("configuration done");
	}

    public String getJsonPayload(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }
    
    public void dataInit() {
    	Author author1 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
    	em.persist(author1);
    	
    	Author author2 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
    	em.persist(author2);
    	
		Book book1 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.idNumber().hashCode()).authors(Arrays.asList(author1)).build();
		Book book2 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.idNumber().hashCode()).authors(Arrays.asList(author1)).build();
		Book book3 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.idNumber().hashCode()).authors(Arrays.asList(author2)).build();
		
		em.merge(book1);
		em.merge(book2);
		em.merge(book3);
		
		em.flush();
    }
}
