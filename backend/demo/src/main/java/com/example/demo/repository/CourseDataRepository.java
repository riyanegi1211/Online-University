package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Course;
import com.example.demo.model.CourseData;
import com.example.demo.model.Student;

public interface CourseDataRepository extends JpaRepository<CourseData,Long>{
    List<CourseData> findAllByCourse(Course course);
}
