package com.example.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.courses.model.CourseData;

public interface CourseDataRepository extends JpaRepository<CourseData, Long>{
    
}
