package com.bskyb.db.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Mode {

	ALL("all"), NONE("none");
	
	private String value;
	
	private Mode(String mode) {
		this.value = mode;
	}
	
	@JsonValue
    public String getValue() {
        return value;
    }
	
	@JsonCreator
	public static Mode fromJson(String value) {
		for (Mode scanType : Mode.values()) {
			if (scanType.getValue().equals(value)) {
				return scanType;
			}
		}
		return null;
	}
}
