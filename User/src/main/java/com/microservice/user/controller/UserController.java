package com.microservice.user.controller;

import com.microservice.user.model.User;
import com.microservice.user.service.UserService;
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

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable String userId){
        User user=userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList=userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }
}
