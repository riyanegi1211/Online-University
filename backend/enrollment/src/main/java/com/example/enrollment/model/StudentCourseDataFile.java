package com.example.enrollment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseDataFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long fileId;
    long enrollmentId;
    String fileName;
}