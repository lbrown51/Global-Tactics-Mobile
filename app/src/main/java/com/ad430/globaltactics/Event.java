package com.ad430.globaltactics;

import java.util.Date;

public class Event {
    String date;
    String title;
    String url;

    public Event(String date, String title, String url) {
        this.date = date;
        this.title = title;
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

