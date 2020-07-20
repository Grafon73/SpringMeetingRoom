package com.test.application.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public interface CalendarHeader {
    String[] columnNamesCheck(Date date, int n);

    String[] getColumnNames(Date date);

    String[] getColumnHeaders();

    Date getStart();
}
