package com.bskyb.db.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * This is spring application config file (handled by spring container it will look for all the @beans annotations and make it ready for use by the application)
 */
@Configuration

/*
 * Enable spring mcv specific annotations like @controller @service @repository etc
 */
@EnableWebMvc
/*
 * base package will be used by spring container to scan the beans (service repository component etc) in order to register with container (lookup path) 
 */
@ComponentScan(basePackages = "com.bskyb.db")
public class ApplicationConfig {

}
