package com.microservice.rating.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Rating {
    @Id
    private String id;
    private String feedBack;
    private int rating;
    private String userId;
    private String hotelId;
    public Rating(){}
    public Rating(String id, String feedBack, int rating, String userId, String hotelId) {
        this.id = id;
        this.feedBack = feedBack;
        this.rating = rating;
        this.userId = userId;
        this.hotelId = hotelId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}
