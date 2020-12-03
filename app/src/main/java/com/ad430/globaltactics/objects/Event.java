package com.ad430.globaltactics.objects;

import com.google.firebase.Timestamp;

import java.nio.charset.IllegalCharsetNameException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Event {
    Timestamp from;
    Timestamp to;
    String description;
    String host;

    public Event() {}

    public String getFrom() {
        return DateFormat.getDateInstance(android.icu.text.DateFormat.SHORT).format(from.toDate());
    }

    public String getTo() {
        return DateFormat.getDateInstance(android.icu.text.DateFormat.SHORT).format(to.toDate());
    }

    public String getDate() {
        return getFrom() + " - " + getTo();
    }

    public String getTitle() {
        String from = DateFormat.getDateInstance(android.icu.text.DateFormat.FULL).format(this.from.toDate());

        String[] splitDate = from.split(",");

        String monthAndDay = splitDate[1];

        String month = monthAndDay.split(" ")[1];

        String year = splitDate[2];

        return month.toUpperCase() + " " + year;
    }

    public Integer getIntDate() {
        Date date = this.from.toDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH));
        String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

        String yearMonth = year;

        if (month.length() < 2) {
            yearMonth = yearMonth + "0" + month;
        }
        else {
            yearMonth = yearMonth + month;
        }

        if (day.length() < 2) {
            yearMonth = yearMonth + "0" + day;
        }
        else {
            yearMonth = yearMonth + day;
        }

        return Integer.parseInt(yearMonth);
    }

    public String getDescription() {
        return description;
    }

    public String getHost() {
        return host;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    public void setTo(Timestamp to) {
        this.to = to;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
