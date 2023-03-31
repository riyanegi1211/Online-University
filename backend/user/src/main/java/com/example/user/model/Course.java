package com.example.user.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    // @Column(name = "title")
    // private String title;

    // @Column(name = "description")
    // private String description;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "teacher_id")
    private Long teacherId;
    // private Teacher teacher;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private List<CourseData> courseData;

    @Column(name = "status")
    private String status;

    @Column(name = "total_lectures")
    private Integer totalLectures;

}