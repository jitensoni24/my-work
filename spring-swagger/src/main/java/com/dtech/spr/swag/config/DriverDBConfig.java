package com.dtech.spr.swag.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.dtech.spr.swag.environment.Dev;
import com.dtech.spr.swag.environment.Local;

@Dev
@Local
@Configuration
public class DriverDBConfig {

	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("data.source.driver.class.name"));
		ds.setUrl(env.getProperty("data.source.url"));
		ds.setUsername(env.getProperty("data.source.username"));
		ds.setPassword(env.getProperty("data.source.password"));

		return ds;
	}
}
