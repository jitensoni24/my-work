package com.bskyb.db.resources;

import com.bskyb.db.enums.Type;
import com.fasterxml.jackson.annotation.JsonInclude;

public class AddressResource {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Type type;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String street;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String city;

	public AddressResource() {}
	
	public AddressResource(Type type, String street, String city) {
		this.type = type;
		this.street = street;
		this.city = city;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
