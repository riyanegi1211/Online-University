package com.example.enrollment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.enrollment.model.CourseList;
import com.example.enrollment.model.CourseSummary;
import com.example.enrollment.model.Enrollment;
import com.example.enrollment.model.StudentCourseData;
import com.example.enrollment.model.StudentCourseDataAttendance;
import com.example.enrollment.model.StudentList;
import com.example.enrollment.repository.EnrollmentRepository;
import com.example.enrollment.repository.StudentCourseDataAttendanceRepository;

@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentCourseDataAttendanceRepository studentCourseDataAttendanceRepository;

    // will only return courseId
    @GetMapping("courses/student/{userId}")
    public List<CourseList> getCoursesForUserId(@PathVariable long userId) {
        List<Enrollment> enrollments = enrollmentRepository.findAllByUserId(userId);
        List<CourseList> cList = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            cList.add(new CourseList(enrollment.getCourseId()));
        }
        return cList;
    }

    // will only return studentId
    @GetMapping("courses/{courseId}")
    public List<StudentList> getStudentForCourseId(@PathVariable long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findAllByCourseId(courseId);
        List<StudentList> cList = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            cList.add(new StudentList(enrollment.getUserId()));
        }
        return cList;
    }

    // will only return studentId
    @GetMapping("courses/{courseId}/student/{userId}/attendance")
    public List<StudentCourseData> getCourseStudentAttendance(@PathVariable long courseId, @PathVariable long userId) {
        Enrollment enrollment = enrollmentRepository.findByCourseIdAndUserId(courseId, userId).orElse(null);
        if (enrollment == null)
            return null;
        List<StudentCourseDataAttendance> attendanceList = studentCourseDataAttendanceRepository
                .findAllByEnrollmentId(enrollment.getEnrollmentId());
        List<StudentCourseData> cList = new ArrayList<>();

        for (StudentCourseDataAttendance attendance : attendanceList) {
            cList.add(new StudentCourseData(enrollment.getUserId(), enrollment.getCourseId(), attendance.getDataId()));
        }

        return cList;
    }
}
