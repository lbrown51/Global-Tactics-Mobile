package com.ad430.globaltactics;

import android.util.Log;

public class Expert {
    int id;
    String name;
    String title;
    String location;
    String specialties;
    String description;
    String linkedin;

    public Expert() {}

//    public Expert(String name, String title, String location, String specialties, String description) {
//        this.name = name;
//        this.title = title;
//        this.location = location;
//        this.specialties = specialties;
//        this.description = description;
//        this.linkedin = linkedin;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.replace("\n", "");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.replace("\n", "");
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location.replace("\n", "");
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties.replace("\n", "");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.trim().replaceAll("[\n]{2,}", "\n\n");
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin.replace("\n", "");
    }
}
