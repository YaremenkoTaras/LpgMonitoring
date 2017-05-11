package com.yaremenko.lpgmonitoring.dao.impl;

import com.yaremenko.lpgmonitoring.dao.interfaces.EventDao;
import com.yaremenko.lpgmonitoring.entities.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Taras
 * @since 21.04.2017
 */
@Component
public class EventDaoImpl implements EventDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Event> getEvents(MeasureSystem system) {

        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Event> criteria = builder.createQuery(Event.class);
        Root<Event> root = criteria.from(Event.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get(Event_.measureSystem), system));

        List<Event> eventList = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

        return eventList;
    }

    @Transactional
    @Override
    public List<Event> getEvents(Company company) {

        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Event> criteria = builder.createQuery(Event.class);
        Root<Event> root = criteria.from(Event.class);
        Join<Event, MeasureSystem> systemJoin = root.join(Event_.measureSystem);
        Predicate predicate = builder.equal(systemJoin.get(MeasureSystem_.company), company);
        criteria.select(root);
        criteria.where(predicate);
        List<Event> eventList = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

        return eventList;
    }

    @Transactional
    @Override
    public List<Event> getEvents(LocalDateTime fromDate, LocalDateTime toDate) {

        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Event> criteria = builder.createQuery(Event.class);
        Root<Event> root = criteria.from(Event.class);
        criteria.select(root);
        criteria.where(builder.and(
                builder.greaterThan(root.get(Event_.date), fromDate),
                builder.lessThan(root.get(Event_.date), toDate)
                ));

        List<Event> eventList = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

        return eventList;
    }

    @Transactional
    @Override
    public Event getEvent(Integer id) {
        return sessionFactory.getCurrentSession().find(Event.class, id);
    }
}
