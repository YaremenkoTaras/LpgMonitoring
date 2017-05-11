package com.yaremenko.lpgmonitoring.dao.impl;

import com.yaremenko.lpgmonitoring.dao.interfaces.Dao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Taras
 * @since 11.05.2017
 */
public abstract class AbstractDao<T , ID extends Serializable> implements Dao <T , ID>{

    private Class<T> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    protected AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    @Transactional
    @Override
    public void createEntity(T entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    @Transactional
    @Override
    public void saveOrUpdateEntity(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    @Transactional
    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Transactional
    @Override
    public T findById(ID id) {
        return (T) sessionFactory.getCurrentSession().get(persistentClass, id);
    }

    @Transactional
    @Override
    public List<T> findAll() {

        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
        Root<T> root = criteria.from(persistentClass);
        criteria.select(root);

        List<T>  list = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        System.out.println(list);
        return list;
    }

    /*protected Class<T> getPersistentClass() {
        return persistentClass;
    }*/
}
