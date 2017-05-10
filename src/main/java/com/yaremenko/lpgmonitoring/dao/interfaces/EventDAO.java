package com.yaremenko.lpgmonitoring.dao.interfaces;

import com.yaremenko.lpgmonitoring.entities.Company;
import com.yaremenko.lpgmonitoring.entities.Event;
import com.yaremenko.lpgmonitoring.entities.MeasureSystem;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Taras
 * @since 21.04.2017
 */
public interface EventDAO {

    List<Event> getEvents(MeasureSystem system);
    List<Event> getEvents(Company company);
    List<Event> getEvents(LocalDateTime fromDate, LocalDateTime toDate);
    Event getEvent(Integer id);

}
