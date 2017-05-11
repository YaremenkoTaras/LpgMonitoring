package com.yaremenko.lpgmonitoring.dao.interfaces;

import com.yaremenko.lpgmonitoring.entities.Company;
import com.yaremenko.lpgmonitoring.entities.User;

import java.util.List;

/**
 * @author Taras
 * @since 20.04.2017
 */
public interface UserDao extends Dao<User,Integer>{

    List<User> getUsers(Company company);

}
