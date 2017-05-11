package com.yaremenko.lpgmonitoring.dao.impl;

import com.yaremenko.lpgmonitoring.dao.interfaces.MeasureSystemDao;
import com.yaremenko.lpgmonitoring.entities.Company;
import com.yaremenko.lpgmonitoring.entities.MeasureSystem;
import com.yaremenko.lpgmonitoring.entities.MeasureSystem_;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Taras
 * @since 21.04.2017
 */
@Component
public class MeasureSystemDaoImpl implements MeasureSystemDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<MeasureSystem> getMeasureSystems(Company company) {

        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<MeasureSystem> criteria = builder.createQuery(MeasureSystem.class);
        Root<MeasureSystem> root = criteria.from(MeasureSystem.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get(MeasureSystem_.company),company));

        List<MeasureSystem>  measureSystems = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

        return measureSystems;
    }

    @Override
    public MeasureSystem getMeasureSystems(Integer serialNumber) {
        return sessionFactory.getCurrentSession().find(MeasureSystem.class, serialNumber);
    }
}
