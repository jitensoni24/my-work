package com.dtech.spr.swag.integration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.dtech.spr.swag.config.SpringSwaggerApplication;
import com.github.javafaker.Faker;

@TestPropertySource(value = {"classpath:/env/unit-test/persistence.properties"})
@ActiveProfiles("unit-test")
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@WebAppConfiguration
@Rollback
@Transactional
@ContextConfiguration(classes = {SpringSwaggerApplication.class})
public abstract class IntegrationTest {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	WebApplicationContext wac;
	
	MockMvc mockMvc;
	
	public static final Faker faker = new Faker();
	
	@Before
	public void init() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void contextLoads() {
		System.out.println("context loaded");
	}
}
