package com.ad430.globaltactics;

import android.app.Application;

import java.util.ArrayList;

public class EventRecords extends Application {
    public static ArrayList<Event> events;

    @Override
    public void onCreate() {
        super.onCreate();

        events = new ArrayList<Event>();
        events.add(new Event("Oct. 27-29, 2020", "GSMA Thrive North America featuring the CTIA 5G Summit", "http://www.gsmathrive.com/northamerica/"));
        events.add(new Event("Oct. 28, 2020", "Preparing for the next globalisation: International business after covid-19", "http://events.economist.com/events-conferences/asia/webinar-preparing-next-glocalisation"));
        events.add(new Event("Oct. 28, 2020", "IMAGINE: Nonprofit Online", "http://www.indopacificbusinessforum.com/"));
        events.add(new Event("Oct. 28-29, 2020", "Indo-Pacific Business Forum, Hanoi, Vietnam", "http://www.gsmathrive.com/asiapacific/"));
        events.add(new Event("Oct. 27-29, 2020", "GSMA Thrive North America featuring the CTIA 5G Summit", "http://www.gsmathrive.com/northamerica/"));
        events.add(new Event("Oct. 28, 2020", "Preparing for the next globalisation: International business after covid-19", "http://events.economist.com/events-conferences/asia/webinar-preparing-next-glocalisation"));
        events.add(new Event("Oct. 28, 2020", "IMAGINE: Nonprofit Online", "http://www.indopacificbusinessforum.com/"));
        events.add(new Event("Oct. 28-29, 2020", "Indo-Pacific Business Forum, Hanoi, Vietnam", "http://www.gsmathrive.com/asiapacific/"));
        events.add(new Event("Oct. 27-29, 2020", "GSMA Thrive North America featuring the CTIA 5G Summit", "http://www.gsmathrive.com/northamerica/"));
        events.add(new Event("Oct. 28, 2020", "Preparing for the next globalisation: International business after covid-19", "http://events.economist.com/events-conferences/asia/webinar-preparing-next-glocalisation"));
        events.add(new Event("Oct. 28, 2020", "IMAGINE: Nonprofit Online", "http://www.indopacificbusinessforum.com/"));
        events.add(new Event("Oct. 28-29, 2020", "Indo-Pacific Business Forum, Hanoi, Vietnam", "http://www.gsmathrive.com/asiapacific/"));
    }
}
