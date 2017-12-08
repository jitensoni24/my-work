package com.bskyb.db.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bskyb.db.entity.Author;
import com.bskyb.db.entity.Blog;
import com.bskyb.db.entity.Book;
import com.bskyb.db.service.AuthorService;

@RestController
@RequestMapping(value = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public void initdata() {
    	authorService.initdata();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<Author> getAll() {
    	
        List<Author> all = authorService.getAll();
		return all;
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Author get(@PathVariable Long id) {
        return authorService.get(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Author get(@PathVariable String name) {
        return authorService.get(name);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Author create(@RequestBody @Valid Author author) {
        return authorService.create(author);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Author update(@PathVariable Long id, @RequestBody @Valid Author author) {
        return authorService.update(id, author);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }

    /* BOOK */

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/book/{authorId}", method = RequestMethod.GET)
    public List<Book> getAllAuthorBooks(@PathVariable Long authorId) {
        List<Book> all = authorService.getAllAuthorBooks(authorId);
		return all;
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/book/max/pages", method = RequestMethod.GET)
    public List<Book>  getBookWithMaxPages() {
    	List<Book> books = authorService.getBookWithMaxPages();
		return books;
    }
    
    

    /* BLOG */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/blog/{authorId}", method = RequestMethod.GET)
    public List<Blog> getAllAuthorBlogs(@PathVariable Long authorId) {
        List<Blog> all = authorService.getAllAuthorBlogs(authorId);
		return all;
    }

    
}
