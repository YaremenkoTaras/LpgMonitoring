package com.yaremenko.lpgmonitoring.dao.interfaces;

import com.yaremenko.lpgmonitoring.entities.Company;
import com.yaremenko.lpgmonitoring.entities.User;

import java.util.List;

/**
 * @author Taras
 * @since 20.04.2017
 */
public interface UserDAO {

    List<User> getUsers(Company company);
    User getUser(Integer userId);

}
