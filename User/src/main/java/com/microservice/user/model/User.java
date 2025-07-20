package com.microservice.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String about;
    @Transient // jpa ignore
    private List<Rating> ratingList;

    public User(){}

    public User(String id, String name, String email, String about, List<Rating> ratingList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.about = about;
        this.ratingList = ratingList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
