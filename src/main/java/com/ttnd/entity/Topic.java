package com.ttnd.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int topicid;

    String name;

    @ManyToOne
    User createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdated;

    Visibility visibility;

    public enum Visibility{Public,Private};

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicid=" + topicid +
                ", name='" + name + '\'' +
                ", createdBy=" + createdBy +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", visibility=" + visibility +
                '}';
    }
}
