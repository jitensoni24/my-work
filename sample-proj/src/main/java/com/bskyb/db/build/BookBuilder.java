package com.bskyb.db.build;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bskyb.db.entity.Author;
import com.bskyb.db.entity.Book;

public class BookBuilder {

	private String title;
	
	private Integer version;
	
	private Set<Author> authors = new HashSet<>();
	
	private Integer pages;
	
	private BookBuilder() {}
	
	public static BookBuilder book() {
		return new BookBuilder();
	}
	
	public BookBuilder title(String value) {
		this.title = value;
		return this;
	}
	
	public BookBuilder version(Integer value) {
		this.version = value;
		return this;
	}
	
	public BookBuilder pages(Integer value) {
		this.pages = value;
		return this;
	}
	
	public BookBuilder authors(List<Author> value) {
		Set<Author> authors = new HashSet<>(value);
		this.authors = authors;
		return this;
	}
	
	public Book build() {
		Book book = new Book();
		book.setTitle(title);
		book.setVersion(version);
		book.setPages(pages);
		book.setAuthors(authors);
		return book;
	}
}
