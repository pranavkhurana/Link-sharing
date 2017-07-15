package com.ttnd.entity;

import javax.persistence.*;

@Entity
public class ResourceRating {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int resourceratingid;

    @ManyToOne
    Resource resource;

    @ManyToOne
    User user;

    Integer score;

    public int getResourceratingid() {
        return resourceratingid;
    }

    public void setResourceratingid(int resourceratingid) {
        this.resourceratingid = resourceratingid;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
