package com.example.enrollment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.enrollment.model.CourseSummary;
import com.example.enrollment.model.Enrollment;
import com.example.enrollment.model.StudentList;
import com.example.enrollment.repository.EnrollmentRepository;

@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // will only return courseId
    @GetMapping("courses/{userId}")
    public List<CourseSummary> getCoursesForUserId(@PathVariable long userId) {
        List<Enrollment> enrollments = enrollmentRepository.findAllByUserId(userId);
        List<CourseSummary> cList = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            cList.add(new CourseSummary(enrollment.getCourseId(), null));
        }
        return cList;
    }

    // will only return studentId
    @GetMapping("courses/{userId}")
    public List<StudentList> getStudentForCourseId(@PathVariable long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findAllByCourseId(courseId);
        List<StudentList> cList = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            cList.add(new StudentList(enrollment.getUserId()));
        }
        return cList;
    }
}
