package com.dtech.lambda.person;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@JsonProperty(value = "id")
	private Integer id;
	@JsonProperty(value = "name")
	private String name;
	@JsonProperty(value = "age")
	private Integer age;
	@JsonProperty(value = "gender")
	private Gender gender;
	
}
