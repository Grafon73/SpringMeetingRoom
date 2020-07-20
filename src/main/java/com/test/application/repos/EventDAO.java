package com.test.application.repos;

import com.test.application.model.Event;

import java.util.List;

public interface EventDAO {
    List<Event> allEvents();
    void add(Event event);
    void delete(Event event);
    Event getByID(int id);
    void edit(Event event);
}
