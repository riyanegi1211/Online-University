package com.example.enrollment.repository;

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
public class StudentCourseDataAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long attendanceId;

    @Column(name = "enrollment_id")
    long enrollmentId;

    @Column(name = "data_id")
    long dataId;
}

