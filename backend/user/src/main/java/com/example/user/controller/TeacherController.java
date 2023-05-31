package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.user.CourseService;
import com.example.user.model.Course;
import com.example.user.model.CourseData;
import com.example.user.model.CourseList;
import com.example.user.model.CourseSummary;
import com.example.user.model.Student;
import com.example.user.model.Teacher;
import com.example.user.repository.StudentRepository;
import com.example.user.repository.TeacherRepository;
import com.example.user.repository.UserRepository;

@RestController
// @CrossOrigin(origins = "http://localhost:8000/*")
@RequestMapping("/api/teacher")
public class TeacherController {
    /*

/teacher
    /courses
    /courses/{id}
    /courses/{id}/{dataId}
    /profile
    /courses/{id}/student ?
    /misc

    */

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    // @Autowired
    // private UserRepository userRepository;

    @Autowired 
    private CourseService courseService;

    // long teacherId;
    // TeacherController() {
    //     this.teacherId = 5;
    // }

    @GetMapping("{uid}")
    public String getName(@PathVariable long uid) {
        return "You are " + uid;
    }

    @GetMapping("{uid}/courses")
    public List<CourseList> getCourses(@PathVariable long uid) {
        return courseService.getCourses(uid);
    }

    @GetMapping("{uid}/course/{courseId}")
    public Course getCoursesById(@PathVariable long uid, @PathVariable int courseId) {
        return courseService.getCourseById(uid, courseId);
    }

    @GetMapping("{uid}/course/{courseId}/{lectureId}")
    public CourseData getCourseDataById(@PathVariable long uid, @PathVariable int courseId, @PathVariable int lectureId) {
        return courseService.getCourseDataById(uid, courseId, lectureId);
    }

    @GetMapping("{uid}/profile")
    public Teacher getProfile(@PathVariable long uid) {
        return teacherRepository.findById(uid).orElse(null);
    }

    @GetMapping("{uid}/students")
    public List<Student> getAllStudent(@PathVariable long uid) {
        return studentRepository.findAll();
    }

}
