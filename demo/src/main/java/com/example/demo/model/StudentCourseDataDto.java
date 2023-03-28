package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseDataDto {

    private long studentId;

    private long courseId;

    private String courseName;

    private int totalLectures;

    private int attendedLectures;

}
