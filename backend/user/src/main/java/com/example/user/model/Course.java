package com.example.user.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class Course implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;
 
    @Column(name = "title")
    @JsonIgnore
    private String title;
 
    @Column(name = "course_name")
    private String courseName;

    @Column(name= "course_code")
    private String courseCode;

    @Column(name= "status")
    private String status;

    @Column(name = "total_lectures")
    private Integer totalLectures;
 
    // @OneToOne
    // @JoinColumn(name = "user_id")
    // @JsonIgnore
    // private Teacher teacher;
 
    // @Column(name = "start_date")
    // @JsonIgnore
    // private LocalDate startDate;
 
    // @Column(name = "end_date")
    // @JsonIgnore
    // private LocalDate endDate;

    // @JsonIgnore
    // private List<CourseData> courseData;

    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CourseData> courseData;

}