package com.bskyb.db.exception;

public class UserExistsException extends RuntimeException {

	String message;
	
	public UserExistsException(String message) {
		this.message = message;
	}

	private static final long serialVersionUID = 1L;

}
