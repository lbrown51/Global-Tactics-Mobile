package com.ad430.globaltactics;

public class Expert {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
}
