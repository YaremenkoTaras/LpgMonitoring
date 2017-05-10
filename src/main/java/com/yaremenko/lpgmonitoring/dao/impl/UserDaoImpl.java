package com.yaremenko.lpgmonitoring.dao.impl;

import com.yaremenko.lpgmonitoring.dao.interfaces.UserDAO;
import com.yaremenko.lpgmonitoring.entities.Company;
import com.yaremenko.lpgmonitoring.entities.User;
import com.yaremenko.lpgmonitoring.entities.User_;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Taras
 * @since 20.04.2017
 */
@Component
public class UserDaoImpl implements UserDAO{


    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<User> getUsers(Company company) {

        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get(User_.company),company));

        List<User>  users = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

        return users;
    }

    @Transactional
    @Override
    public User getUser(Integer userId) {

        return sessionFactory.getCurrentSession().find(User.class, userId);
    }
}
