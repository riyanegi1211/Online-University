package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student;
import com.example.demo.model.StudentCourseData;

public interface StudentCourseDataRepository extends JpaRepository<StudentCourseData, Long> {
    List<StudentCourseData> findAllByStudent(Student student);
}
