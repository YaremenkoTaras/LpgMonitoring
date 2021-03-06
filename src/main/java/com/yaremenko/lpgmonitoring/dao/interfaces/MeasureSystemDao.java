package com.yaremenko.lpgmonitoring.dao.interfaces;

import com.yaremenko.lpgmonitoring.entities.Company;
import com.yaremenko.lpgmonitoring.entities.MeasureSystem;

import java.util.List;

/**
 * @author Taras
 * @since 21.04.2017
 */
public interface MeasureSystemDao extends Dao<MeasureSystem,Integer>{


    List<MeasureSystem> getMeasureSystems(Company company);
    MeasureSystem getMeasureSystem(Integer serialNumber);

}
