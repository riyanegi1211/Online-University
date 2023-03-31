package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
