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
import com.example.user.model.CalenderItem;
import com.example.user.model.Course;
import com.example.user.model.CourseData;
import com.example.user.model.CourseList;
import com.example.user.model.CourseStudent;
import com.example.user.model.CourseSummary;
import com.example.user.model.Student;
import com.example.user.repository.CalenderRepository;
import com.example.user.repository.StudentRepository;
import com.example.user.repository.UserRepository;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("student")
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

    // @Autowired
    // private UserRepository userRepository;

    @Autowired 
    private CourseService courseService;

    @Autowired
    private CalenderRepository calenderRepository;

    // long studentId;
    // StudentController() {
    //     this.studentId = 1;
    // }

    @GetMapping("/{sid}")
    public String checkConnection(@PathVariable long sid) {
        return "You are student " + sid;
    }

    @GetMapping("{sid}/courses")
    public List<CourseList> getCourses(@PathVariable long sid) {
        return courseService.getCourses(sid);
    }

    @GetMapping("{sid}/course/{courseId}")
    public CourseStudent getCoursesById(@PathVariable long sid, @PathVariable int courseId) {
        return courseService.getCourseByIdWithData(sid, courseId);
    }

    @GetMapping("{sid}/course/{courseId}/{lectureId}")
    public CourseData getCourseDataById(@PathVariable long sid, @PathVariable int courseId, @PathVariable int lectureId) {
        return courseService.getCourseDataById(sid, courseId, lectureId);
    }

    @GetMapping("{sid}/profile")
    public Student getProfile(@PathVariable long sid) {
        Student s = studentRepository.findById(sid).orElse(null);
        if (s == null) {
            System.out.println("Student requested is null");
        } else System.out.println(s);
        return s;
    }

    @GetMapping("{sid}/calender")
    public List<CalenderItem> getCalender(@PathVariable long sid) {
        List<CalenderItem> calItem = calenderRepository.findAllByUserId(sid); //.orElse(null)
        return calItem;
    }


    
}
