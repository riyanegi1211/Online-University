package com.example.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.User;
import com.example.user.model.UserIdentifier;
import com.example.user.model.UserLogin;
import com.example.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/login")
public class LoginController {
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public UserIdentifier login(@RequestBody UserLogin user) {
        User u = userRepository.findByUsername(user.getUsername()).orElse(null);
        if (u != null && u.getPassword() == "{noop}"+user.getPassword()) {
            return new UserIdentifier(u.getId(), u.getRole().toString());
        }
        return new UserIdentifier();
    }
    
}
