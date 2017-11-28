package com.bskyb.db.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.bskyb.db.environment.All;
import com.bskyb.db.security.CustomAuthenticationProvider;


@All
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/*@Autowired
    private Environment env;*/
	
    @Value("${password.algorithm}")
    private String passwordAlgorithm;

    @Autowired
    DataSource ds;

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
    	System.out.println("---STEP 3--- SecurityConfig.authenticationManager ");
        return super.authenticationManager();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	System.out.println("---STEP 4--- SecurityConfig.configure authenticationProvider ");
        
    	CustomAuthenticationProvider authenticationProvider = new CustomAuthenticationProvider(ds, passwordAlgorithm);

        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
    	System.out.println("---STEP 9--- SecurityConfig.configure webSecurity ");
    	
    	webSecurity.ignoring().antMatchers("/")
	        .and().ignoring().antMatchers("/login")
	        .and().ignoring().antMatchers("/o2c")
	        .and().ignoring().antMatchers("/resources/**")
	        .and().ignoring().antMatchers("/v2/api-docs/**")
	        .and().ignoring().antMatchers("/version");
    }
}
