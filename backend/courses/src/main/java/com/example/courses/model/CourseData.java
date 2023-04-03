package com.example.courses.model;

import java.io.Serializable;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "course_data")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseData implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long courseDataId;
    
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonBackReference
    Course course;

    @Column(name= "title")
    String title;
    
    @Column(name = "link")
    String link;
}