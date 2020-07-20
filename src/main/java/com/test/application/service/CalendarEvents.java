package com.test.application.service;

import java.util.ArrayList;
import java.util.Map;

public interface CalendarEvents {
    Map<Integer, ArrayList<String>> getData();

    Map<Integer, ArrayList<String>> getMapOfEvents();
}
