package com.example.App.service;

import com.example.App.entity.User;
import com.example.App.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Save user for registration
    public void register(User user) {
        userRepository.save(user);
    }

    // Login method: checks email and password
    public Optional<User> login(String email, String password) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst();
    }
    
 // Inside UserService.java
    public void update(User user) {
        // If you are using Spring Data JPA, .save() works for both create and update
        // as long as the User object has its primary key (ID) set.
        userRepository.save(user); 
    }
}
