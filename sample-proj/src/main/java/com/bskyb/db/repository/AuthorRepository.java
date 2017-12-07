package com.bskyb.db.repository;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.springframework.stereotype.Repository;

import com.bskyb.db.build.AuthorBuilder;
import com.bskyb.db.build.BookBuilder;
import com.bskyb.db.builder.BlogBuilder;
import com.bskyb.db.entity.Author;
import com.bskyb.db.entity.Author_;
import com.bskyb.db.entity.Blog;
import com.bskyb.db.entity.Book;
import com.bskyb.db.entity.Book_;
import com.github.javafaker.Faker;

@Repository
public class AuthorRepository extends com.bskyb.db.repository.Repository<Author>{

    @PersistenceContext
    EntityManager entityManager;
    
	public static final Faker fake = Faker.instance();

	AuthorRepository() {
		super(Author.class);
	}

	public List<Book> getAllAuthorBooks(Long authorId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Book> bookQuery = builder.createQuery(Book.class);
		
		Root<Book> root = bookQuery.from(Book.class);
		
		SetJoin<Book, Author> join = root.join(Book_.authors, JoinType.INNER);
		
		/*
		 * All the books with or without authors
		 * Remove the predicate for this
		 * This will increase the returned no of books and test will fail
		 *  
		 * SetJoin<Book, Author> join = root.join(Book_.authors, JoinType.LEFT);
		 * */
		
		Predicate predicate1 = builder.equal(join, authorId);
		
		/*Predicate predicate2 = builder.lessThan(root.get(Book_.pages), new Integer(10));*/
		
		bookQuery.where(builder.and(predicate1/*, predicate2*/));
		
		List<Book> resultList = entityManager.createQuery(bookQuery).getResultList();
		
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public List<Blog> getAllAuthorBlogs(Long authorId) {
		
		String query = " select * from blog b, author a, publicationblog pb where b.id = pb.blogid and pb.authorid = a.id and a.id = :authorId";
		
		return entityManager.createNativeQuery(query, Blog.class).setParameter("authorId", authorId).getResultList();
	}

	public Author get(String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Author> query = builder.createQuery(Author.class);
		Root<Author> root = query.from(Author.class);

		Predicate condition = builder.equal(root.get(Author_.name), name);
		query.where(condition);

		return entityManager.createQuery(query).getSingleResult();
	}
	
    public void dataInit() {
    	Author author1 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
    	Author author2 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
    	Author author3 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();    	

    	entityManager.persist(author1);
    	entityManager.persist(author2);
    	entityManager.persist(author3);
    	
		Book book1 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.idNumber().hashCode()).authors(Arrays.asList(author1)).build();
		Book book2 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.idNumber().hashCode()).authors(Arrays.asList(author1)).build();
		Book book3 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.idNumber().hashCode()).authors(Arrays.asList(author2)).build();
		Book book4 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.idNumber().hashCode()).build();

		entityManager.merge(book1);
		entityManager.merge(book2);
		entityManager.merge(book3);
		entityManager.merge(book4);
		
		Blog blog1 = BlogBuilder.blog().title(fake.book().title()).version(fake.code().hashCode()).url(fake.internet().url()).authors(Arrays.asList(author1)).build();
		Blog blog2 = BlogBuilder.blog().title(fake.book().title()).version(fake.code().hashCode()).url(fake.internet().url()).authors(Arrays.asList(author1)).build();
		Blog blog3 = BlogBuilder.blog().title(fake.book().title()).version(fake.code().hashCode()).url(fake.internet().url()).authors(Arrays.asList(author3)).build();

		entityManager.merge(blog1);
		entityManager.merge(blog2);
		entityManager.merge(blog3);
		
		entityManager.flush();
    }
	
}
