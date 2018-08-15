package com.hrms.sample;

public class Link {
    public Link(String url, String description) {
        this.url = url;
        this.description = description;
    }

    private  String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;


}
