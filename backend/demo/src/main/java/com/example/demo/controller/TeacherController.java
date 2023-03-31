package com.example.demo.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/teacher")
public class TeacherController {
    @GetMapping("/")
    public String getName(Principal principal) {
        return "you are an teacher" + principal.getName();
    }
}
