package com.example.backend.controller;

import com.example.backend.DTO.LoginUser;
import com.example.backend.DTO.RegisterInputDTO;
import com.example.backend.model.User;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody RegisterInputDTO registerInputDTO) {
        User user = userService.registerUser(registerInputDTO);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/login")
    public User loginUser(@RequestBody LoginUser loginuser) {
        return userService.loginUser(loginuser.getUsername(), loginuser.getPassword());
    }
}
