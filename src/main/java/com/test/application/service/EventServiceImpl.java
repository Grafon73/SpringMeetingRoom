package com.test.application.service;

import com.test.application.model.Event;
import com.test.application.repos.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventDAO eventDAO;


    @Override
    @Transactional
    public List<Event> allEvents() {
        return eventDAO.allEvents();
    }

    @Override
    @Transactional
    public void add(Event event) {
        eventDAO.add(event);
    }

    @Override
    @Transactional
    public void delete(Event event) {
        eventDAO.delete(event);
    }

    @Override
    @Transactional
    public Event getByID(int id) {
        return eventDAO.getByID(id);
    }

    @Override
    @Transactional
    public void edit(Event event) {
        eventDAO.edit(event);
    }
}
