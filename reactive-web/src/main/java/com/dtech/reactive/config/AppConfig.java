package com.dtech.reactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dtech.reactive.model.Coffee;

@Configuration
@ComponentScan(value = {"com.dtech.reactive"})
@EnableWebMvc
public class AppConfig {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();

	}
	
	@Bean
	public RedisTemplate<String, Coffee> redisTemplate() {
		RedisTemplate<String, Coffee> template = new RedisTemplate<String, Coffee>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}
	
}
