package com.bskyb.db.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.bskyb.db.enums.Type;

@Embeddable
public class Address {

	@Column(name="type_")
	@Enumerated(EnumType.STRING)
	private Type type;
	
	private String street;
	
	private String city;
	
	public Address() {}

	public Address(Type type, String street, String city) {
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
