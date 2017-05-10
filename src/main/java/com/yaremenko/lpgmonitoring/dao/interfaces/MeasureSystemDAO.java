package com.yaremenko.lpgmonitoring.dao.interfaces;

import com.yaremenko.lpgmonitoring.entities.Company;
import com.yaremenko.lpgmonitoring.entities.MeasureSystem;

import java.util.List;

/**
 * @author Taras
 * @since 21.04.2017
 */
public interface MeasureSystemDAO {


    List<MeasureSystem> getMeasureSystems(Company company);
    MeasureSystem getMeasureSystems(Integer serialNumber);

}
