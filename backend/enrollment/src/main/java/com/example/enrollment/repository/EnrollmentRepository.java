package com.example.enrollment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.enrollment.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
    List<Enrollment> findAllByUserId(long userId);
    List<Enrollment> findAllByCourseId(long courseId);
    Optional<Enrollment> findByCourseIdAndUserId(long courseId, long userId);
}
