package com.example.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.enrollment.model.StudentCourseDataFile;

public interface StudentCourseDataFileRepository extends JpaRepository<StudentCourseDataFile, Long> {
    List<StudentCourseDataFile> findAllByEnrollmentId(long enrollmentId);
}
