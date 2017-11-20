package com.bskyb.db.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.bskyb.db.environment.UnitTest;

@UnitTest
@Configuration
@PropertySource(value = {
		"classpath:/env/application.properties",
		"classpath:/env/unit-test/persistence.properties",
		"file:${file.environment.conf}" }, ignoreResourceNotFound = true)
public class TestPropertiesConfig {}
