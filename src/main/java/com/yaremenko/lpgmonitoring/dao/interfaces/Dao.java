package com.yaremenko.lpgmonitoring.dao.interfaces;

import java.util.List;

/**
 * @author Taras
 * @since 11.05.2017
 */
public interface Dao <T>{

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    T findById();

    List<T> findAll();

}
