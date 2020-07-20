package com.test.application.service;

import com.test.application.service.CalendarEvents;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalendarEventsImpl implements CalendarEvents {
    ArrayList<String> eventByHour = new ArrayList<>();
    Map<Integer,ArrayList<String>> mapOfEvents = getData();

    @Override
    public Map<Integer,ArrayList<String>> getData(){
for (int i=0;i<8;i++){
    eventByHour.add("");
}
        Map<Integer,ArrayList<String>> mapOfEvents = new HashMap<>();
        for(int i = 1; i<25; i++){
            mapOfEvents.put(i,eventByHour);
    }
return mapOfEvents;

    }

    @Override
    public Map<Integer, ArrayList<String>> getMapOfEvents() {
        return mapOfEvents;
    }
}
