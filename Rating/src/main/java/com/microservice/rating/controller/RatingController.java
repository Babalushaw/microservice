package com.microservice.rating.controller;

import com.microservice.rating.model.Rating;
import com.microservice.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ratings")
@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getSingleRating(@PathVariable String ratingId){
        Rating rating=ratingService.getRatingId(ratingId);
        return ResponseEntity.status(HttpStatus.OK).body(rating);
    }
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating newRating=ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String userId) {
        List<Rating> ratingList = ratingService.getAllRatingByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(ratingList);
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingOfHotel(@PathVariable String hotelId){
        List<Rating> ratingList=ratingService.getAllRatingByHoteld(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(ratingList);
    }
    @GetMapping("/get")
    public String get(){
        return "working";
    }
}
