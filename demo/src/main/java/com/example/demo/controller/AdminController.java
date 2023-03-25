package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private TeacherRepository teacherRepository;

    // @Autow

    @GetMapping("/")
    public String getName(Principal principal) {
        return "you are an admin" + principal.getName();
    }

    // @GetMapping("getStudentList")
    // public List<Student> getStudentList() {
    //     return studentRepository.findAll();
    // }

    @GetMapping("getTeacherList")
    public List<Teacher> getTeacherList() {
        return teacherRepository.findAll();
    }
}
