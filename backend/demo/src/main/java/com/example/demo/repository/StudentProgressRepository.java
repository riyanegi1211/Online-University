package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.StudentProgress;
import com.example.demo.model.StudentProgressDTO;
import com.example.demo.model.StudentProgressId;

public interface StudentProgressRepository extends JpaRepository<StudentProgress,StudentProgressId>{
    // @Query("Select s from studentProgress sp whrere studentId=?1 and courseId=?2")
    // List<StudentProgress> findAllStudentProgresses(Student s1, Course c1);
    // @Query("SELECT sp.course_data_id, sp.student_id, sp.course_id FROM student_progress sp")
    // List<StudentProgressDTO> findAllProgress();
}
