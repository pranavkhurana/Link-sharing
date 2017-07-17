package com.ttnd.entity;

import org.hibernate.validator.constraints.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int userid;

    @org.hibernate.validator.constraints.NotEmpty(message ="Email can't be empty")
    @org.hibernate.validator.constraints.Email(message="Invalid email")
    @Size(min=8,max=30,message="Email must be between 8 and 30 characters")
    String email;

    @org.hibernate.validator.constraints.NotEmpty(message="Password is required")
    @Size(min=8,max=30,message="Password must be between 8 and 30 characters. THis message is from validation")
    String password;

    @org.hibernate.validator.constraints.NotEmpty
    String firstname;

    @org.hibernate.validator.constraints.NotEmpty
    String lastname;

    @Column(length=100000)
    byte[] photo;

    boolean admin;

    boolean active;

    @Temporal(TemporalType.DATE)
    Date dateCreated;

    @Temporal(TemporalType.DATE)
    Date lastUpdated;

    @NotEmpty
    String username;

    @Transient
    String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", admin=" + admin +
                ", active=" + active +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", username='" + username + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
