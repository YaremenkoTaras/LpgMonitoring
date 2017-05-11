package com.yaremenko.lpgmonitoring.dao.interfaces;

import com.yaremenko.lpgmonitoring.entities.Company;

import java.util.List;

/**
 * @author Taras
 * @since 21.04.2017
 */
public interface CompanyDao{

    List<Company> getCompanies();

}
