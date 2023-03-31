package com.example.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @GetMapping("/courses/{id}/{dataId}")
    public CourseData getCourseData(@PathVariable long id, @PathVariable long dataId) {
        return null;
    }
}
