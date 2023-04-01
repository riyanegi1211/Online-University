package com.example.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;
import com.example.demo.model.Teacher;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private CourseRepository courseRepository;

	// @Autow

	@GetMapping("/")
	public String getName(Principal principal) {
		return "you are an admin : " + principal.getName();
	}

	@GetMapping("getStudentList")
	public List<StudentDTO> getStudentList() {
		List<Student> students = studentRepository.findAll();
		List<StudentDTO> studentDTOs = new ArrayList<>();

		for (Student student : students) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setUsername(student.getUsername());
			studentDTO.setFirstName(student.getFirstName());
			studentDTO.setLastName(student.getLastName());
			studentDTOs.add(studentDTO);
		}

		return studentDTOs;
	}

	@GetMapping("getTeacherList")
	public List<Teacher> getTeacherList() {
		return teacherRepository.findAll();
	}

	@GetMapping("getCoursesList")
	public List<Course> getCoursesList(){
		return courseRepository.findAll();
	}

    @PostMapping("saveCourses")
    public Course saveCourses(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @DeleteMapping("deleteData/{id}")
    public void deletdata(@PathVariable long id){
        courseRepository.deleteById(id);
    }
}
