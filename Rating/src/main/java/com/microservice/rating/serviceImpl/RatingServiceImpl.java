package com.microservice.rating.serviceImpl;

import com.microservice.rating.model.Rating;
import com.microservice.rating.repository.RatingRepository;
import com.microservice.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating getRatingId(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow();
    }

    @Override
    public Rating saveRating(Rating rating) {
        String id= UUID.randomUUID().toString();
        rating.setId(id);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingByHoteld(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
