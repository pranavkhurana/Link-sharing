package com.ttnd.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;

@Entity
public class LinkResource extends Resource {

    @NotEmpty
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LinkResource{" +
                "url='" + url + '\'' +
                ", resourceid=" + resourceid +
                ", description='" + description + '\'' +
                ", createdBy=" + createdBy +
                ", topic=" + topic +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
