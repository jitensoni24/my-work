package com.bskyb.db.repository;

import com.bskyb.db.entity.Book;

@org.springframework.stereotype.Repository
public class BookRepository extends Repository<Book>{

	public BookRepository() {
		super(Book.class);
	}
}
