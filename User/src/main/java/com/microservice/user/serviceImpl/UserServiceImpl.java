package com.microservice.user.serviceImpl;

import com.microservice.user.exception.ResourceNotFoundException;
import com.microservice.user.model.Hotel;
import com.microservice.user.model.Rating;
import com.microservice.user.model.User;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User saveUser(User user) {
        String randomUserId= UUID.randomUUID().toString();
        user.setId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(String userId) {
        String message;
        try{
            userRepository.deleteById(userId);
            message= "Deleted Successfully";
        }catch (Exception e){
            message="UnSuccessfully";
        }
        return message;
    }

    @Override
    public User getUserById(String userId) {
        User user= userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User not present with given id"));
        Rating[] ratingList= restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+userId, Rating[].class);

        assert ratingList != null;
        List<Rating> ratingHotel= Arrays.stream(ratingList).map(rating->{
            String hotelId=rating.getHotelId();
            ResponseEntity<Hotel> hotel=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+hotelId, Hotel.class);
            rating.setHotel(hotel.getBody());
            return rating;
        }).collect(Collectors.toList());
        user.setRatingList(ratingHotel);
        return user;

    }
}
