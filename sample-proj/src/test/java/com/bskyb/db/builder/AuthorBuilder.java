package com.bskyb.db.builder;

import com.bskyb.db.entity.Author;

public class AuthorBuilder {

	private String name;
	
	private String email;
	
	private AuthorBuilder() {}
	
	public static AuthorBuilder author() {
		return new AuthorBuilder();
	}
	
	public AuthorBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public AuthorBuilder email(String email) {
		this.email = email;
		return this;
	}
	
	public Author build() {
		Author author = new Author();
		author.setName(name);
		author.setEmail(email);
		return author;
	}
}
