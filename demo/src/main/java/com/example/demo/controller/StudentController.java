package com.example.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.model.StudentCourseData;
import com.example.demo.model.StudentCourseDataDto;
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

    @GetMapping("/")
    public String getName(Principal principal) {
        return "you are an student" + principal.getName();
    }

    // Stackoverflow error
    // @GetMapping("getCourses")
    // public List<StudentCourseData> getCourses(Authentication auth) {

    // User u = userRepository.findByUsername(auth.getName()).orElseThrow();
    // Student s1 = studentRepository.findById(u.getId()).orElseThrow();
    // System.out.println("Username = " + s1.getUsername());
    // List<StudentCourseData> studentCourseDataList =
    // studentCourseDataRepository.findAllByStudent(s1);
    // return studentCourseDataList;
    // }

    @GetMapping("getCourses")
    public List<StudentCourseDataDto> getCourses(Authentication auth) {

        StudentCourseDataDto sampleDto = new StudentCourseDataDto(1, 1, "Sample Course", 1, 3);
        List<StudentCourseDataDto> studentCourseDataList = new ArrayList<StudentCourseDataDto>();

        studentCourseDataList.add(sampleDto);

        return studentCourseDataList;
    }
}
