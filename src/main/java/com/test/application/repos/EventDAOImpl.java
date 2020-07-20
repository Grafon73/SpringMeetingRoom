package com.test.application.repos;

import com.test.application.model.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventDAOImpl implements EventDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> allEvents() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Event").list();
    }

    @Override
    public void add(Event event) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(event);
    }

    @Override
    public void delete(Event event) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(event);
    }

    @Override
    public Event getByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Event.class, id);
    }

    @Override
    public void edit(Event event) {
        Session session = sessionFactory.getCurrentSession();
        session.update(event);
    }

}
