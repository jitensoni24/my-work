package com.bskyb.db.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {
		"classpath:/env/application.properties",
		"classpath:/env/persistence.properties",
		"file:${file.environment.conf}" }, ignoreResourceNotFound = true)
public class TestPropertiesConfig {}
