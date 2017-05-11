package com.yaremenko.lpgmonitoring.dao.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * @author Taras
 * @since 11.05.2017
 */
public interface Dao <T , ID extends Serializable>{

    void createEntity(T entity);

    void saveOrUpdateEntity(T entity);

    void delete(T entity);

    T findById(ID id);

    List<T> findAll();

}
