package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

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

@Entity
@Table(name = "courses")
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
    private String title;
 
    @Column(name = "description")
    private String description;
 
    @OneToOne
    @JoinColumn(name = "user_id")
    private Teacher teacher;
 
    @Column(name = "start_date")
    private LocalDate startDate;
 
    @Column(name = "end_date")
    private LocalDate endDate;

}