package com.ad430.globaltactics;

import com.google.firebase.Timestamp;

public class Event {
    Timestamp from;
    Timestamp to;
    String description;
    String host;

    public Event() {}

    public Timestamp getFrom() {
        return from;
    }

    public Timestamp getTo() {
        return to;
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
