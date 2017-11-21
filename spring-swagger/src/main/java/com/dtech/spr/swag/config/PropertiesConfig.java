package com.dtech.spr.swag.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.dtech.spr.swag.environment.Dev;
import com.dtech.spr.swag.environment.Local;

@Configuration
public class PropertiesConfig {

	@Local
	@Configuration
	@PropertySource(value = {"classpath:/env/application.properties, classpath:/evn/local/persistence.properties"}, ignoreResourceNotFound = true)
	static class LocalProps {}
	
	@Dev
	@Configuration
	@PropertySource(value = {"classpath:/env/application.properties, classpath:/evn/dev/persistence.properties"}, ignoreResourceNotFound = true)
	static class DevProps {}
	
}
