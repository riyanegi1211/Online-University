package com.example.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.courses.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
