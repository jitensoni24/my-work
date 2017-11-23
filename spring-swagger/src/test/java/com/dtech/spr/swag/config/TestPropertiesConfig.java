package com.dtech.spr.swag.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@UnitTest
@Configuration
@PropertySource(name = "test-property", 
				value = "classpath:/env/unit-test/persistence.properties", ignoreResourceNotFound = true)
public class TestPropertiesConfig { }
