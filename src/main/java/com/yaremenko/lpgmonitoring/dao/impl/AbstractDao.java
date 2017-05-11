package com.yaremenko.lpgmonitoring.dao.impl;

import com.yaremenko.lpgmonitoring.dao.interfaces.Dao;

import java.util.List;

/**
 * @author Taras
 * @since 11.05.2017
 */
public class AbstractDao<T> implements Dao <T>{

    private Class<T> persistentClass;


    @Override
    public void create(Object entity) {

    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public T findById() {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }
}
