package com.ttnd.entity;

import javax.persistence.Entity;

@Entity
public class LinkResource extends Resource {

    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
