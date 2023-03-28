package com.example.demo.model;

import java.io.Serializable;

// import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_course_data")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentCourseData implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    // @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    // @JsonBackReference
    private Course course;

    @Column(name = "progress")
    private int progress;

    // Constructors, getters, and setters
}