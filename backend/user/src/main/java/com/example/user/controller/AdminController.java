package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.CourseService;
import com.example.user.model.Admin;
import com.example.user.model.Course;
import com.example.user.model.CourseData;
import com.example.user.model.CourseList;
import com.example.user.model.CourseSummary;
import com.example.user.model.Student;
import com.example.user.model.Teacher;
import com.example.user.repository.AdminRepository;
import com.example.user.repository.StudentRepository;
import com.example.user.repository.TeacherRepository;
import com.example.user.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/admin")
public class AdminController {
    

    /*
/admin
    /courses
    /courses/{id}
    /courses/{id}/{dataId}
    /profile
    
    /students
    /students/{id}
    /teacher
    /teacher/{id}

    /misc

    */

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private CourseService courseService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    // long adminId;
    // AdminController() {
    //     this.adminId = 5;
    // }

    @GetMapping("{uid}/courses")
    public List<Course> getCourses(@PathVariable long uid) {
        return courseService.getAllCourses();
    }

    @GetMapping("{uid}/course/{courseId}")
    public Course getCoursesById(@PathVariable long uid, @PathVariable int courseId) {
        return courseService.getCourseById(uid, courseId);
    }

    @GetMapping("{uid}/course/{courseId}/{lectureId}")
    public CourseData getCourseDataById(@PathVariable long uid, @PathVariable int courseId, @PathVariable int lectureId) {
        return courseService.getCourseDataById(uid, courseId, lectureId);
    }

    @GetMapping("{uid}/student")
    public List<Student> getAllStudent(@PathVariable long uid) {
        return studentRepository.findAll();
    }

    @GetMapping("{uid}/student/{studentId}")
    public Student getStudentById(@PathVariable long uid, @PathVariable long studentId) {
        // System.out.println(courseService.test()); 
        return studentRepository.findById(studentId).orElse(null);
    }

    @GetMapping("{uid}/teacher")
    public List<Teacher> getAllTeacher(@PathVariable long uid) {
        return teacherRepository.findAll();
    }

    @GetMapping("{uid}/teacher/{teacherId}")
    public Teacher getTeacherById(@PathVariable long uid, @PathVariable long teacherId) {
        return teacherRepository.findById(teacherId).orElse(null);
    }

    @GetMapping("{uid}/profile")
    public Admin getProfile(@PathVariable long uid) {
        return adminRepository.findById(uid).orElse(null);
    }

    @PostMapping(value="{uid}/courses")
    public String saveCourses(@RequestBody Course course) {
        //TODO: process POST request
        return this.courseService.saveCourses(course);
    }

    @PutMapping(value="{uid}/courses/{cid}")
    public String updateCourses(@PathVariable Long uid,@PathVariable Long cid ,@RequestBody Course course) {
        //TODO: process PUT request
        
        return this.courseService.updateCourses(course,cid);
    }

    @DeleteMapping(value="{uid}/courses/{cid}")
    public String deleteCourse(@PathVariable Long uid,@PathVariable Long cid) {
        //TODO: process PUT request
        
        return this.courseService.deleteCourse(cid);
    }
    
}
