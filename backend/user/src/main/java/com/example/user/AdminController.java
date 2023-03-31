package com.example.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.Admin;
import com.example.user.model.Course;
import com.example.user.model.CourseData;
import com.example.user.model.CourseSummary;
import com.example.user.model.Student;
import com.example.user.model.Teacher;
import com.example.user.repository.AdminRepository;
import com.example.user.repository.StudentRepository;
import com.example.user.repository.TeacherRepository;
import com.example.user.repository.UserRepository;

@RestController
@RequestMapping("/api/admin")
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

    long adminId;
    AdminController() {
        this.adminId = 5;
    }

    @GetMapping("/courses")
    public List<CourseSummary> getCourses() {
        return courseService.getCourses(adminId);
    }

    @GetMapping("/course/{courseId}")
    public Course getCoursesById(@PathVariable int courseId) {
        return courseService.getCourseById(adminId, courseId);
    }

    @GetMapping("/course/{courseId}/{lectureId}")
    public CourseData getCourseDataById(@PathVariable int courseId, @PathVariable int lectureId) {
        return courseService.getCourseDataById(adminId, courseId, lectureId);
    }

    @GetMapping("/student")
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable long studentId) {
        // System.out.println(courseService.test()); 
        return studentRepository.findById(studentId).orElse(null);
    }

    @GetMapping("/teacher")
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @GetMapping("/teacher/{teacherId}")
    public Teacher getTeacherById(@PathVariable long teacherId) {
        return teacherRepository.findById(teacherId).orElse(null);
    }

    @GetMapping("/profile")
    public Admin getProfile() {
        return adminRepository.findById(adminId).orElse(null);
    }
}
