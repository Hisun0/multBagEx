package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Expression;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.annotation.Profiling;
import org.example.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CriteriaUserRepository {
    @Autowired
    private EntityManager entityManager;

    @Profiling(queryType = "Criteria API")
    public List<User> findAll() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(User.class);
        criteriaQuery.select(criteriaQuery.from(User.class));

        var query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Profiling(queryType = "Criteria API")
    public List<User> findByFullNameContaining(String name) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(User.class);
        var root = criteriaQuery.from(User.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.like(root.get("fullName"), "%" + name + "%"));

        var query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
