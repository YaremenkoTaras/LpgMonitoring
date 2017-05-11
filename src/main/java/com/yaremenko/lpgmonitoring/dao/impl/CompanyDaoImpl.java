package com.yaremenko.lpgmonitoring.dao.impl;

import com.yaremenko.lpgmonitoring.dao.interfaces.CompanyDao;
import com.yaremenko.lpgmonitoring.entities.Company;
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
 * @since 21.04.2017
 */
@Component
public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Company> getCompanies() {

        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Company> criteria = builder.createQuery(Company.class);
        Root<Company> root = criteria.from(Company.class);
        criteria.select(root);

        List<Company>  companies = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

        return companies;
    }
}
