package com.bskyb.db.enums;

public enum Type {

	HOME("home"), OFFICE("office");

	private String value;
	
	Type(String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}
}