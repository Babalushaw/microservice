package com.microservice.user.service;

import com.microservice.user.exception.ResourceNotFoundException;
import com.microservice.user.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    String deleteUser(String userId);
    User getUserById(String userId) throws ResourceNotFoundException;

}
