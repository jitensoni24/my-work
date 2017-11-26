package com.dtech.spr.swag.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.dtech.spr.swag.environment.Dev;

@Configuration
public class PropertiesConfig {

//	@Local
//	@Configuration
//	@PropertySource(value = { "classpath:/env/application.properties", "classpath:/env/local/persistence.properties" })
//	static class LocalProps {
//	}

	@Dev
	@Configuration
	@PropertySource(value = { "classpath:/env/application.properties, classpath:/env/dev/persistence.properties" })
	static class DevProps {
		
	}

}
