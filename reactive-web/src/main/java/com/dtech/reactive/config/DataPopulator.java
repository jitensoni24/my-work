package com.dtech.reactive.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.dtech.reactive.model.Coffee;

@Component
public class DataPopulator {

	@Autowired
	private RedisTemplate<String, Coffee> redisTemplate;
	
	@PostConstruct
	public void init() {
		
		for (int i=0; i < 10; i++) {
			Coffee c = new Coffee("latte-"+i, "coffe latte " + i);
			
			redisTemplate.opsForValue().set(c.getId(), c);
		}
	}

}
