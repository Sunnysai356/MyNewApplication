package com.example.backend.service;

import com.example.backend.DTO.RegisterInputDTO;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(RegisterInputDTO user) {
        // Add checks for existing users if necessary
        User application=new User();
        application.setUsername(user.getUsername());
        application.setEmail(user.getEmail());
        application.setPassword(user.getPassword());
        return userRepository.save(application);
    }

    public User loginUser(String username, String password) {
        // This is basic; consider adding encryption and using tokens
        return userRepository.findByUsername(username);
    }
}
