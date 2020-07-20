package com.test.application.controller;


import com.test.application.service.CalendarEventsImpl;
import com.test.application.service.CalendarHeaderImpl;
import com.test.application.model.Event;
import com.test.application.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class EventController {
@Autowired
CalendarHeaderImpl calendarHeader;
@Autowired
CalendarEventsImpl calendarEvents;
@Autowired
EventService eventService;


    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public ModelAndView testPage(@RequestParam(value = "date", required = false) String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        String[] header = new String[7];
        if(name==null||name.isEmpty()){
            header=calendarHeader.getColumnNames(new Date());
        }else{
            try {
                header = calendarHeader.getColumnNames(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(name));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Map<Integer, ArrayList<String>> data = calendarEvents.getData();
        List<Event> events = eventService.allEvents();
        modelAndView.addObject("header", header);
        modelAndView.addObject("daydata", data);
        modelAndView.addObject("events",events);
        return modelAndView;
    }

        @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Event event = eventService.getByID(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editEvent");
        modelAndView.addObject("event", event);
        return modelAndView;
    }
        @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editFilm(@ModelAttribute("event") Event event) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        eventService.edit(event);
        return modelAndView;
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public ModelAndView addPage(@RequestParam(value = "date", required = false) String date,
                                @RequestParam(value = "hour", required = false) String hour) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("date",date);
        modelAndView.addObject("hour",hour);
        modelAndView.setViewName("addEvent");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public ModelAndView addFilm(@ModelAttribute("event") Event event) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        eventService.add(event);
        return modelAndView;
    }
        @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Event event = eventService.getByID(id);
        eventService.delete(event);
        return modelAndView;
    }
}