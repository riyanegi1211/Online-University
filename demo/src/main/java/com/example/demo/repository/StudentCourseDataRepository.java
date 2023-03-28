package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Student;
import com.example.demo.model.StudentCourseData;

public interface StudentCourseDataRepository extends JpaRepository<StudentCourseData, Long> {
    @Query
    List<StudentCourseData> findAllByStudent(Student student);
}
