package com.ttnd.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Resource {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int resourceid;

    @NotEmpty
    String description;

    @ManyToOne
    User createdBy;

    @ManyToOne
    Topic topic;

    @Temporal(TemporalType.DATE)
    Date dateCreated;

    @Temporal(TemporalType.DATE)
    Date lastUpdated;

    @Transient
    int topicid;

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    public int getTopicid() {
        return topicid;
    }

    /*
    public Integer getTopicid() {
        return topicid;
    }

    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }
*/

    public int getResourceid() {
        return resourceid;
    }

    public void setResourceid(int resourceid) {
        this.resourceid = resourceid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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
}
