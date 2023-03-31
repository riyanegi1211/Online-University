package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Optional<Student> findByUser
}
