package com.bskyb.db.repository;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.springframework.stereotype.Repository;

import com.bskyb.db.build.AuthorBuilder;
import com.bskyb.db.build.BookBuilder;
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
		
		Root<Book> bookRoot = bookQuery.from(Book.class);
		
		SetJoin<Book, Author> join = bookRoot.join(Book_.authors);
		
		bookQuery.where(builder.equal(join, authorId));
		
		List<Book> resultList = entityManager.createQuery(bookQuery).getResultList();
		
		return resultList;
	}

	public List<Blog> getAllAuthorBlogs(Long authorId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Blog> query = builder.createQuery(Blog.class);

		Root<Blog> root = query.from(Blog.class);
		
		query.where(builder.equal(root.get("authors.id"), authorId));
		
		List<Blog> resultList = entityManager.createQuery(query).getResultList();

		return resultList;
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
    	entityManager.persist(author1);
    	
    	Author author2 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
    	entityManager.persist(author2);
    	
		Book book1 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.idNumber().hashCode()).authors(Arrays.asList(author1)).build();
		Book book2 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.idNumber().hashCode()).authors(Arrays.asList(author1)).build();
		Book book3 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.idNumber().hashCode()).authors(Arrays.asList(author2)).build();
		
		entityManager.merge(book1);
		entityManager.merge(book2);
		entityManager.merge(book3);
		
		entityManager.flush();
    }
	
}
