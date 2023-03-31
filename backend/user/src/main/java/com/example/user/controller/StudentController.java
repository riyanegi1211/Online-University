package com.example.user.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.CourseService;
import com.example.user.model.Course;
import com.example.user.model.CourseData;
import com.example.user.model.CourseStudent;
import com.example.user.model.CourseSummary;
import com.example.user.model.Student;
import com.example.user.repository.StudentRepository;
import com.example.user.repository.UserRepository;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/student")
public class StudentController {
    /*

/student 
    /courses
    /courses/{id}
    /courses/{id}/{dataId}
    /profile
    /misc - /notification, /calender etc.

    */
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private CourseService courseService;

    long studentId;
    StudentController() {
        this.studentId = 1;
    }

    @GetMapping("/courses")
    public List<CourseSummary> getCourses() {
        return courseService.getCourses(studentId);
    }

    @GetMapping("/course/{courseId}")
    public CourseStudent getCoursesById(@PathVariable int courseId) {
        return courseService.getCourseByIdStudent(studentId, courseId);
    }

    @GetMapping("/course/{courseId}/{lectureId}")
    public CourseData getCourseDataById(@PathVariable int courseId, @PathVariable int lectureId) {
        return courseService.getCourseDataById(studentId, courseId, lectureId);
    }

    @GetMapping("/profile")
    public Student getProfile() {
        Student s = studentRepository.findById(studentId).orElse(null);
        if (s == null) {
            System.out.println("Student requested is null");
        } else System.out.println(s);
        return s;
    }


    
}
