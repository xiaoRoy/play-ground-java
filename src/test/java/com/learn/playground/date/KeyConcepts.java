package com.learn.playground.date;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

public class KeyConcepts {

    @Test
    public void test_duration() {
        DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
        DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);
        Duration duration = new Duration(start, end);
        System.out.println(duration);
    }

    @Test
    public void test_interval() {
        DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
        DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);
        Interval interval = new Interval(start, end);
        System.out.println("interval");
        System.out.println(interval);
    }

    @Test
    public void test_what() {
        LocalDate.parse("121", DateTimeFormat.forPattern("yyyy-MM-dd"));
    }
}
