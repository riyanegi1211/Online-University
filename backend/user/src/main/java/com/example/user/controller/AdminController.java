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
import com.example.user.model.NewStudent;
import com.example.user.model.Role;
import com.example.user.model.Student;
import com.example.user.model.Teacher;
import com.example.user.model.User;
import com.example.user.repository.AdminRepository;
import com.example.user.repository.StudentRepository;
import com.example.user.repository.TeacherRepository;
import com.example.user.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



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

    // long adminId;
    // AdminController() {
    //     this.adminId = 5;
    // }

    @GetMapping("{uid}")
    public String getName(@PathVariable long uid) {
        return "You are " + uid;
    }

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

    // @PutMapping(value="{uid}/courses/{cid}")
    // public String updateCourses(@PathVariable Long uid,@PathVariable Long cid ,@RequestBody Course course) {
    //     //TODO: process PUT request
        
    //     return this.courseService.updateCourses(course,cid);
    // }

    @PutMapping(value="{uid}/courses/{cid}")
    public Course updateCourses(@PathVariable Long uid,@PathVariable Long cid ,@RequestBody Course course) {
        //TODO: process PUT request
        System.out.println("User id is: "+ uid);
        return this.courseService.updateCourses(course,cid);
    }

    @DeleteMapping(value="{uid}/courses/{cid}")
    public String deleteCourses(@PathVariable Long uid,@PathVariable Long cid) {
        return this.courseService.deleteCourse(cid);
    }

    @GetMapping("{uid}/students")
    public List<Student> getAllStudent(@PathVariable long uid) {
        return studentRepository.findAll();
    }

    @GetMapping("{uid}/students/{studentId}")
    public Student getStudentById(@PathVariable long uid, @PathVariable long studentId) {
        // System.out.println(courseService.test()); 
        return studentRepository.findById(studentId).orElse(null);
    }

    @PostMapping(value="{uid}/students")
    public String saveStudent(@RequestBody NewStudent student) {
        // System.out.println(student);
        //this.studentRepository.save(student);
        // User u= this.userRepository.save(new User("default129", "default@123", Role.STUDENT));
        Student s1 = Student.studentBuilder()
            .username("default129")
            .password("{noop}default@123")
            .role(Role.STUDENT)
            .firstName(student.getFirstName())
            .lastName(student.getLastName())
            .studentSemester(student.getStudentSemester())
            .studentBranch(student.getStudentBranch())
            .studentId(student.getStudentId())
            .build();

            studentRepository.save(s1);
        return "Successful";
    }

    @PutMapping(value="{uid}/students/{sid}")
    public Student updateStudent(@PathVariable Long sid,@RequestBody NewStudent student) {
        // System.out.println("Success"+this.studentRepository.save(student));
        System.out.println(student);
        // Student s1 = Student.studentBuilder()
        //     .id(sid)
        //     // .username("default129")
        //     // .password("{noop}default@123")
        //     // .role(Role.STUDENT)
        //     .firstName(student.getFirstName())
        //     .lastName(student.getLastName())
        //     .studentSemester(student.getStudentSemester())
        //     .studentBranch(student.getStudentBranch())
        //     .studentId(student.getStudentId())
        //     .build();
        // .orElseThrow(() -> new EntityNotFoundException("Student not found with id " + sid)
        Student s1 = studentRepository.findById(sid).orElse(null);
        if(s1 == null)
        {
            return null;
        }
        s1.setFirstName(student.getFirstName());
        s1.setLastName(student.getLastName());
        s1.setStudentSemester(student.getStudentSemester());
        s1.setStudentBranch(student.getStudentBranch());
        s1.setStudentId(student.getStudentId());
        return studentRepository.save(s1);
    }

    @DeleteMapping(value="{uid}/students/{sid}")
    public String deleteStudent(@PathVariable Long sid){
        this.studentRepository.deleteById(sid);
        return "Successful";
    }
}
