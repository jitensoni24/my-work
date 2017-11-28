package com.bskyb.db.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.bskyb.db.environment.Dev;
import com.bskyb.db.environment.Local;

@Dev
@Local
@Configuration
public class DriverDataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {

    	System.out.println("---STEP 1--- DriverDataSourceConfig.datasource ");
    	
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getProperty("data.source.driver.class.name"));
        ds.setUrl(env.getProperty("data.source.url"));
        ds.setUsername(env.getProperty("data.source.username"));
        ds.setPassword(env.getProperty("data.source.password"));

        return ds;
    }

}
