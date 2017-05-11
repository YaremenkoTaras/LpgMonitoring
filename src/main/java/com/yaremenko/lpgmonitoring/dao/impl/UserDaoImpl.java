package com.yaremenko.lpgmonitoring.dao.impl;

import com.yaremenko.lpgmonitoring.dao.interfaces.UserDao;
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
public class UserDaoImpl extends AbstractDao<User,Integer> implements UserDao {


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

        List<User>  users = sessionFactory.openSession().createQuery(criteria).getResultList();

        return users;
    }
}
