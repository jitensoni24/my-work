package com.dtech.reactive.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("coffee")
public class Coffee implements Serializable {

	private static final long serialVersionUID = 6614371405235189677L;

	private String id;
	
	private String name;
}