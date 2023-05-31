package com.example.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.enrollment.model.StudentCourseDataAttendance;

public interface StudentCourseDataAttendanceRepository extends JpaRepository<StudentCourseDataAttendance, Long> {
    List<StudentCourseDataAttendance> findAllByEnrollmentId(long enrollmentId);
}
