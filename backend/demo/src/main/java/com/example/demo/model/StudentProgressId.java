package com.example.demo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentProgressId implements Serializable{
    public StudentProgressId(Student s1, Course c1, CourseData cd) {
        this.course=c1;
        this.student=s1;
        this.data=cd;
    }
    Course course;
    Student student;
    CourseData data;
    // long studentId;
    // long courseId;
    // long dataId;    
}
