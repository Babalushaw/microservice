package com.microservice.rating.service;

import com.microservice.rating.model.Rating;

import java.util.List;

public interface RatingService {
    Rating getRatingId(String ratingId);

    Rating saveRating(Rating rating);

    List<Rating> getAllRatingByUserId(String userId);

    List<Rating> getAllRatingByHoteld(String hotelId);
}
