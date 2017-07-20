package com.ttnd.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int subscriptionid;

    @ManyToOne
    Topic topic;

    @ManyToOne
    User user;

    public enum Seriousness{Casual,Serious,VerySerious}

    Seriousness seriousness;

    @Temporal(TemporalType.DATE)
    Date dateCreated;

    public Seriousness getSeriousness() {
        return seriousness;
    }

    public void setSeriousness(Seriousness seriousness) {
        this.seriousness = seriousness;
    }

    public int getSubscriptionid() {
        return subscriptionid;
    }

    public void setSubscriptionid(int subscriptionid) {
        this.subscriptionid = subscriptionid;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "subscriptionid=" + subscriptionid +
                ", topic=" + topic +
                ", user=" + user +
                ", seriousness=" + seriousness +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
