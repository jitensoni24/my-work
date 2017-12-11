package com.bskyb.db.repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.springframework.stereotype.Repository;

import com.bskyb.db.build.AuthorBuilder;
import com.bskyb.db.build.BlogBuilder;
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
    EntityManager em;
    
	public static final Faker fake = Faker.instance();

	AuthorRepository() {
		super(Author.class);
	}

	public List<Book> getAllAuthorBooks(Long authorId) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
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
		
		List<Book> resultList = em.createQuery(bookQuery).getResultList();
		
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public List<Blog> getAllAuthorBlogs(Long authorId) {
		
		String query = " select * from blog b, author a, publicationblog pb where b.id = pb.blogid and pb.authorid = a.id and a.id = :authorId";
		
		return em.createNativeQuery(query, Blog.class).setParameter("authorId", authorId).getResultList();
	}
	
	public List<Book> getBookWithMaxPages() {
		
		//String query = "select * from book b where b.pages = (select max(bb.pages) from book bb)";
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Book> bookQuery = builder.createQuery(Book.class);
		Root<Book> root = bookQuery.from(Book.class);

		CriteriaQuery<Integer> subquery = builder.createQuery(Integer.class);
		Root<Book> subRoot = subquery.from(Book.class);
		Path<Integer> x = subRoot.get(Book_.pages);
		subquery.select(builder.max(x));
		Integer singleResult = em.createQuery(subquery).getSingleResult();
		
		bookQuery.where(builder.equal(root.get(Book_.pages), singleResult));
		
		List<Book> resultList = em.createQuery(bookQuery).getResultList();
		
		return resultList;
		
	}

	public Author get(String name) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Author> query = builder.createQuery(Author.class);
		Root<Author> root = query.from(Author.class);

		Predicate condition = builder.equal(root.get(Author_.name), name);
		query.where(condition);

		return em.createQuery(query).getSingleResult();
	}
	
    public void dataInit() {
    	/*Author author1 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
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

		Blog dbBlog1 = em.merge(blog1);
		Blog dbBlog2 = em.merge(blog2);
		Blog dbBlog3 = em.merge(blog3);
		
		*/
    	
    	Author author1 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
    	Author author2 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();
    	Author author3 = AuthorBuilder.author().name(fake.name().name()).email(fake.internet().emailAddress()).build();

    	Author dba1 = em.merge(author1);
    	Author dba2 = em.merge(author2);
    	Author dba3 = em.merge(author3);
    	em.flush();
    	
		Book book1 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(9).build();
		Book book2 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.number().randomDigit()).build();
		Book book3 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.number().randomDigit()).build();
		Book book4 = BookBuilder.book().title(fake.book().title()).version(fake.code().hashCode()).pages(fake.number().randomDigit()).build();
		
		Book dbBook1 = em.merge(book1);
		Book dbBook2 = em.merge(book2);
		Book dbBook3 = em.merge(book3);
		em.merge(book4);
		em.flush();
		
		
		dbBook1.setAuthors(new HashSet<>(Arrays.asList(dba1)));
		dbBook2.setAuthors(new HashSet<>(Arrays.asList(dba1)));
		dbBook3.setAuthors(new HashSet<>(Arrays.asList(dba2)));
		em.merge(dbBook1);
		em.merge(dbBook2);
		em.merge(dbBook3);

		Blog blog1 = BlogBuilder.blog().title(fake.book().title()).version(fake.code().hashCode()).url(fake.internet().url()).build();
		Blog blog2 = BlogBuilder.blog().title(fake.book().title()).version(fake.code().hashCode()).url(fake.internet().url()).build();
		Blog blog3 = BlogBuilder.blog().title(fake.book().title()).version(fake.code().hashCode()).url(fake.internet().url()).build();

		Blog dbBlog1 = em.merge(blog1);
		Blog dbBlog2 = em.merge(blog2);
		Blog dbBlog3 = em.merge(blog3);
		em.flush();
		
		dbBlog1.setAuthors(new HashSet<>(Arrays.asList(dba1)));
		dbBlog2.setAuthors(new HashSet<>(Arrays.asList(dba2)));
		dbBlog3.setAuthors(new HashSet<>(Arrays.asList(dba3)));
		
		em.flush();
    }
	
}
