package com.ttnd.entity;

import javax.persistence.Entity;

@Entity
public class DocumentResource extends Resource{
    String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
