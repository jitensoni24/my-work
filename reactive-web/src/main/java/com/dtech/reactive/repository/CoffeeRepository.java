package com.dtech.reactive.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.dtech.reactive.model.Coffee;

@Repository
public class CoffeeRepository {
	@Autowired
	private RedisTemplate<String, Coffee> redisTemplate;
	
	public void create(Coffee coffee) {
        ValueOperations<String, Coffee> values = redisTemplate.opsForValue();
        values.getOperations().persist(coffee.getId());
	}
	
	public Coffee get(String id) {
        ValueOperations<String, Coffee> values = redisTemplate.opsForValue();
        Coffee coffee = values.get(id);
        return coffee;
	}

}
