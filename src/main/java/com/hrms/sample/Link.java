package com.hrms.sample;

public class Link {
  private String id;
  private String url;
  private String description;


  public Link(String url, String description) {
    this(null,url, description);
  }

  public Link(String id, String url, String description) {
    this.id = id;
    this.url = url;
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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




}
