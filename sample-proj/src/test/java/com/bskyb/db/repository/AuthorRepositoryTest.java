package com.bskyb.db.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bskyb.db.build.AuthorBuilder;
import com.bskyb.db.build.BookBuilder;
import com.bskyb.db.builder.BlogBuilder;
import com.bskyb.db.config.ApplicationConfig;
import com.bskyb.db.entity.Author;
import com.bskyb.db.entity.Blog;
import com.bskyb.db.entity.Book;
import com.github.javafaker.Faker;

@ActiveProfiles("unit-test")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
@ContextConfiguration(classes = { ApplicationConfig.class })
@WebAppConfiguration
public class AuthorRepositoryTest {

	public static final Faker fake = Faker.instance();

    @PersistenceContext
    protected EntityManager em;
    
	@Autowired
	AuthorRepository authorRepository;
    
	@Autowired
	BookRepository bookRepository;
	
	@Before
	public void init() throws Exception {
		Author author1 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
    	Author author2 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
    	Author author3 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();

    	em.persist(author1);
    	em.persist(author2);
    	em.persist(author3);
    	
		Book book1 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(9).authors(Arrays.asList(author1)).build();
		Book book2 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.number().randomDigit()).authors(Arrays.asList(author1)).build();
		Book book3 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.number().randomDigit()).authors(Arrays.asList(author2)).build();
		Book book4 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.number().randomDigit()).build();
		
		em.merge(book1);
		em.merge(book2);
		em.merge(book3);
		em.merge(book4);
		
		Blog blog1 = BlogBuilder.blog().title(fake.book().title()).version(fake.code().hashCode()).url(fake.internet().url()).authors(Arrays.asList(author1)).build();
		Blog blog2 = BlogBuilder.blog().title(fake.book().title()).version(fake.code().hashCode()).url(fake.internet().url()).authors(Arrays.asList(author1)).build();
		Blog blog3 = BlogBuilder.blog().title(fake.book().title()).version(fake.code().hashCode()).url(fake.internet().url()).authors(Arrays.asList(author3)).build();

		em.merge(blog1);
		em.merge(blog2);
		em.merge(blog3);
	}
	
	@Test
	public void getAllAuthor() throws Exception {
		List<Author> authors = authorRepository.getAll();
		
		for (Author author : authors) {
			System.out.println(author);
		}
	}
	
	@Test
	public void getAllBooks() throws Exception {
		List<Book> books = bookRepository.getAll();
		for (Book book : books) {
			System.out.println(book);
			Set<Author> authors = book.getAuthors();
			System.out.println(authors.iterator().next().getName());
		}
	}
}
