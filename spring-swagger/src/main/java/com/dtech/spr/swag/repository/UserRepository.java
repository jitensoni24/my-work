package com.dtech.spr.swag.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.dtech.spr.swag.entity.User;

@Repository
public class UserRepository {

	@PersistenceContext
	EntityManager em;
	
	public List<User> getAll() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		
		Root<User> from = query.from(User.class);
		
		query.select(from);
		
		List<User> resultList = em.createQuery(query).getResultList();
		
		return resultList;
	}

	public User get(Long id) {
		return em.find(User.class, id);
	}
	
	public User create(User user) {
		return em.merge(user);
	}

	public void delete(Long userId) {
		User u = get(userId);
		
		if(u != null) {
			em.remove(u);
		}
	}
}
