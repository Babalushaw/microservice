package com.microservice.user.controller;

import com.microservice.user.model.User;
import com.microservice.user.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
       User newUser= userService.saveUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
    int retryCount=0;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @Retry(name = "ratingHotelRetry",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> findUserById(@PathVariable String userId){
        System.out.println("Retry Count: "+retryCount);
        retryCount++;
        User user=userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
        System.out.println("Fallback is executed because service is down: "+ex.getMessage());
        User user=new User();
        user.setId("12334");
        user.setName("Dummy");
        user.setEmail("dummy@gamil.com");
        user.setAbout("This user is created dummy because some service is down");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList=userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }
}
