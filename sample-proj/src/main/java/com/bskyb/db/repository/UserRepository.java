package com.bskyb.db.repository;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bskyb.db.entity.User;

@Repository
public class UserRepository extends com.bskyb.db.repository.Repository<User> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserRepository() {
        super(User.class);
    }

    @Override
    public User get(Long id) {
        try {
            return super.get(id);
        } catch (NoResultException e) {
            throw new NoResultException("user.constraint.not.found");
        }
    }

    public User get(String username) {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);

            Predicate condition = builder.equal(builder.lower(root.get("username")), username.toLowerCase());
            query.where(condition);

            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            throw new NoResultException("user.constraint.not.found");
        }
    }

    @Override
    public User create(User user) {
        try {
            return super.create(user);
        } catch (PersistenceException exception) {
            throw handlePersistenceException(exception, "user.constraint.duplicate");
        }
    }

    @Override
    public User update(Long id, User user) {
        try {
            user = super.update(id, user);
            removeAccessToken(user.getUsername());
        } catch (NoResultException e) {
            throw new NoResultException("user.constraint.not.found");
        } catch (PersistenceException exception) {
            throw handlePersistenceException(exception, "user.constraint.duplicate");
        }

        return user;
    }

    @Override
    public void delete(Long id) {
        User user = get(id);

        if (user != null) {
            super.delete(id);

            removeAccessToken(user.getUsername());
        }
    }

    private void removeAccessToken(String username) {
        jdbcTemplate.update("DELETE FROM oauth_access_token WHERE user_name like ?", username);
    }
}
