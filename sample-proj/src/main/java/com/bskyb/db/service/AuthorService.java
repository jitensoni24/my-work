package com.bskyb.db.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bskyb.db.entity.Author;
import com.bskyb.db.entity.Blog;
import com.bskyb.db.entity.Book;
import com.bskyb.db.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	public List<Author> getAll() {
		return authorRepository.getAll();
	}
	
	public List<Book> getAllAuthorBooks(Long authorId) {
		return authorRepository.getAllAuthorBooks(authorId);
	}

	public List<Blog> getAllAuthorBlogs(Long authorId) {
		return authorRepository.getAllAuthorBlogs(authorId);
	}

	public Author get(Long id) {
		return authorRepository.get(id);
	}

	public Author get(String name) {
		return authorRepository.get(name);
	}

	@Transactional
	public Author create(@Valid Author author) {
		return authorRepository.create(author);
	}

	@Transactional
	public Author update(Long id, @Valid Author author) {
		return authorRepository.update(id, author);
	}

	@Transactional
	public void delete(Long id) {
		authorRepository.delete(id);
	}

	@Transactional
	public void initdata() {
		authorRepository.dataInit();
	}
	
}
