package com.ttnd.entity;

import javax.persistence.*;

@Entity
public class ReadingItem {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int readingitemid;

    @ManyToOne
    User createdBy;

    @ManyToOne
    Resource resource;

    boolean isRead;

    public int getReadingitemid() {
        return readingitemid;
    }

    public void setReadingitemid(int readingitemid) {
        this.readingitemid = readingitemid;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
