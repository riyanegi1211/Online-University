package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.CourseService;
import com.example.user.model.Course;
import com.example.user.model.CourseData;
import com.example.user.model.CourseSummary;
import com.example.user.model.Teacher;
import com.example.user.repository.TeacherRepository;
import com.example.user.repository.UserRepository;

@RestController
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

    // @Autowired
    // private UserRepository userRepository;

    @Autowired 
    private CourseService courseService;

    long teacherId;
    TeacherController() {
        this.teacherId = 5;
    }

    @GetMapping("/courses")
    public List<CourseSummary> getCourses() {
        return courseService.getCourses(teacherId);
    }

    @GetMapping("/course/{courseId}")
    public Course getCoursesById(@PathVariable int courseId) {
        return courseService.getCourseById(teacherId, courseId);
    }

    @GetMapping("/course/{courseId}/{lectureId}")
    public CourseData getCourseDataById(@PathVariable int courseId, @PathVariable int lectureId) {
        return courseService.getCourseDataById(teacherId, courseId, lectureId);
    }

    @GetMapping("/profile")
    public Teacher getProfile() {
        return teacherRepository.findById(teacherId).orElse(null);
    }

}
