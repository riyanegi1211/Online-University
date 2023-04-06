package com.example.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.user.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Optional<Student> findByUser
    @Query("SELECT s.studentBranch , COUNT(s) FROM Student s GROUP BY s.studentBranch")
    List<Object[]> countStudentsByStudentBranch();

    @Query("SELECT s.studentSemester , COUNT(s) FROM Student s GROUP BY s.studentSemester")
    List<Object[]> countStudentsByStudentSemester();
}
