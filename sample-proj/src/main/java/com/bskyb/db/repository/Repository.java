package com.bskyb.db.repository;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.exception.ConstraintViolationException;

import com.bskyb.db.entity.Identity;

public abstract class Repository<T extends Identity> {

    @PersistenceContext
    EntityManager entityManager;

    Class<T> entityClass;

    Repository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T get(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityClass);
        Root<T> root = query.from(entityClass);

        Predicate condition = builder.equal(root.get("id"), id);
        query.where(condition);

        return entityManager.createQuery(query).getSingleResult();
    }

    public List<T> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityClass);
        Root<T> root = query.from(entityClass);

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }

    public T create(T entity) {
        entity.setId(null);
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }

    public T update(Long id, T entity) {
        entity.setId(id);
        entity = entityManager.merge(entity);
        entityManager.flush();
        return entity;
    }

    public void delete(Long id) {
        T identity = get(id);
        entityManager.remove(identity);
    }

    PersistenceException handlePersistenceException(PersistenceException exception, String errorMessage) {
        if (exception.getCause() instanceof ConstraintViolationException) {
            SQLException sqlException = ((ConstraintViolationException) exception.getCause()).getSQLException();
            String constraintName = ((ConstraintViolationException) exception.getCause()).getConstraintName();

            return new PersistenceException(new ConstraintViolationException(errorMessage, sqlException, constraintName));
        } else {
            return exception;
        }
    }

}
