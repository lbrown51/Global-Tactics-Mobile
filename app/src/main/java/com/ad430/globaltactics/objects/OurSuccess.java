package com.ad430.globaltactics.objects;

public class OurSuccess {
    String title;
    String description;
    String parent;
    String imageUrl;

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

    public String getImageUrl() {
        return imageUrl;
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

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String title() {
        return this.getParent() + " " + this.getImageUrl() + " " + this.getDescription();
    }

}
