package com.bskyb.db.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import com.bskyb.db.environment.All;

@All
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	/*
	private static final String RESOURCE_ID = "ss_rest_api";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		
		System.out.println("---STEP 7--- ResourceServerConfig.configure resources ");
		
		resources.resourceId(RESOURCE_ID).stateless(false);
	}
	*/
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		System.out.println("---STEP 8--- ResourceServerConfig.configure http security ");
		
		http.csrf().disable()
			
		 	.authorizeRequests()
		
			//head and option permit all
			.antMatchers(HttpMethod.HEAD, "/**").permitAll()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			
			//lock request for users to ADMIN
			.antMatchers(HttpMethod.GET, "/users/**").access("#oauth2.hasScope('read') and hasAnyRole('ADMIN', 'SUPERADMIN')")
			.antMatchers(HttpMethod.POST, "/users/**").access("#oauth2.hasScope('write') and hasAnyRole('ADMIN', 'SUPERADMIN')")
			.antMatchers(HttpMethod.PUT, "/users/**").access("#oauth2.hasScope('write') and hasAnyRole('ADMIN', 'SUPERADMIN')")
			.antMatchers(HttpMethod.DELETE, "/users/**").access("#oauth2.hasScope('write') and hasAnyRole('ADMIN', 'SUPERADMIN')")
			
			.anyRequest().denyAll();
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
