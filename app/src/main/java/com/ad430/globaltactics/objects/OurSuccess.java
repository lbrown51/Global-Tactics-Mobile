package com.ad430.globaltactics.objects;

public class OurSuccess {
    String title;
    String description;
    String parent;
    String resource;

    public OurSuccess() {

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getParent() {
        return parent;
    }

    public String getResource() {
        return resource;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String title() {
        return this.getParent() + " " + this.getResource() + " " + this.getDescription();
    }

}
