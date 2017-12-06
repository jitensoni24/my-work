package com.bskyb.db.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.bskyb.db.entity.Author;
import com.bskyb.db.entity.Author_;
import com.bskyb.db.entity.Blog;
import com.bskyb.db.entity.Book;

@Repository
public class AuthorRepository extends com.bskyb.db.repository.Repository<Author>{

    @PersistenceContext
    EntityManager entityManager;
    
	AuthorRepository() {
		super(Author.class);
	}

	public List<Book> getAllAuthorBooks(Long authorId) {
		Query query = entityManager.createNativeQuery("select * from book b, author a, publicationbook pb where b.id = pb.bookid and a.id = pb.authorid and a.id = :authorId", Book.class);
		
		query.setParameter("authorId", authorId);
		
		List<Book> resultList = query.getResultList();

		System.out.println(resultList.size());
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
	
}
