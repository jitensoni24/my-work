package com.bskyb.db.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bskyb.db.config.ApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {ApplicationConfig.class})
public abstract class IntegrationTest {

	private static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	protected WebApplicationContext wac;
	
	protected MockMvc mockMvc;

	@Before
	public void init() throws Exception {
		 mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	
	@Test
	public void testSpringContextConfiguration() throws Exception {
		
		LOGGER.info("configuration done");
	}
}
