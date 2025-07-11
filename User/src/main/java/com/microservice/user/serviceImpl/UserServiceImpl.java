package com.microservice.user.serviceImpl;

import com.microservice.user.exception.ResourceNotFoundException;
import com.microservice.user.model.User;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
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
        return userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User not present with given id"));
    }
}
