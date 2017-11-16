package com.dtech.spr.swag.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.dtech.spr.swag.config.SpringSwaggerApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@WebAppConfiguration
@Rollback
@Transactional
@ContextConfiguration(classes = {SpringSwaggerApplication.class})
public class UserIntegrationTest {

	@Autowired
	WebApplicationContext context;
	
	@Before
	public void init() throws Exception {
		
		System.out.println("context loaded : " + context.getApplicationName() );
	}
	
	@Test
	public void testContext() {
		System.out.println("done");
	}
}
