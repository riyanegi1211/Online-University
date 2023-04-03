package com.example.enrollment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enrollment")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long enrollmentId;

    @Column(name = "student_id")
    long userId;

    @Column(name = "course_id")
    long courseId;
}
