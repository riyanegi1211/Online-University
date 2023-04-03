package com.example.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@IdClass(StudentProgressId.class)
@Entity
@Table
@Data
public class StudentProgress implements Serializable{

    public StudentProgress(StudentProgressId spid) {
        this.student= spid.getStudent();
        this.course= spid.getCourse();
        this.data= spid.getData();
    }
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Course course;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnore
    Student student;
   
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_data_id", nullable = false)
    CourseData data;  
}
