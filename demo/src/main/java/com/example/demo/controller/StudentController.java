package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.model.StudentCourseData;
import com.example.demo.model.User;
import com.example.demo.repository.StudentCourseDataRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UserRepository;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentCourseDataRepository studentCourseDataRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getName(Principal principal) {
        return "you are an student" + principal.getName();
    }

    // Stackoverflow error
    // @GetMapping("getCourses")
    // public List<StudentCourseData> getCourses(Principal principal) {

    //     User u = userRepository.findByUsername(principal.getName()).orElseThrow();
    //     Student s1 = studentRepository.findById(u.getId()).orElseThrow();
    //     System.out.println("Username = " + s1.getUsername());
    //     List<StudentCourseData> studentCourseDataList = studentCourseDataRepository.findAllByStudent(s1);
    //     return studentCourseDataList;
    // }

}
