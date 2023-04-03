package com.example.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Calendar;
import com.example.demo.model.Course;
import com.example.demo.model.CourseData;
import com.example.demo.model.Student;
import com.example.demo.model.StudentCourseData;
import com.example.demo.model.StudentCourseDataDto;
import com.example.demo.model.StudentProgress;
import com.example.demo.model.StudentProgressId;
import com.example.demo.model.User;
import com.example.demo.repository.CourseDataRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentCourseDataRepository;
import com.example.demo.repository.StudentProgressRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentCourseDataRepository studentCourseDataRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseDataRepository courseDataRepository;

	@Autowired
	private StudentProgressRepository studentProgressRepository;

	@GetMapping("/")
	public String getName(Principal principal) {
		return "you are an student" + principal.getName();
	}

	@GetMapping("/student")
	public Student getStudent()
	{
		return studentRepository.findById((long)3).orElse(null);
	}

	// Stackoverflow error
	// @GetMapping("getCourses")
	// public List<StudentCourseData> getCourses(Authentication auth) {

	// User u = userRepository.findByUsername(auth.getName()).orElseThrow();
	// Student s1 = studentRepository.findById(u.getId()).orElseThrow();
	// System.out.println("Username = " + s1.getUsername());
	// List<StudentCourseData> studentCourseDataList =
	// studentCourseDataRepository.findAllByStudent(s1);
	// return studentCourseDataList;
	// }


	@GetMapping("getCourses")
	public List<StudentCourseDataDto> getCourses(Authentication auth) {

		StudentCourseDataDto sampleDto = new StudentCourseDataDto(1, 1, "Sample Course", 1, 3);
		List<StudentCourseDataDto> studentCourseDataList = new ArrayList<StudentCourseDataDto>();

		studentCourseDataList.add(sampleDto);

		return studentCourseDataList;
	}

	@GetMapping("/{sid}/calendar")
	public Calendar getCalendar(){
		Calendar calendar= new Calendar("exam", "2023-04-03", "2023-04-10");
		return calendar;
	}

	// @PostMapping("{sid}/courses/{cid}/data/{key}")
	// public void getProgress(@PathVariable long sid, @PathVariable long cid, @PathVariable long key){
	// 	Student s1= studentRepository.findById(sid).orElse(null);
	// 	Course c1= courseRepository.findById(cid).orElse(null);
	// 	CourseData cd= courseDataRepository.findById(key).orElse(null);
	//     StudentProgressId spid= new StudentProgressId(s1,c1,cd); 
	// 	if(this.studentProgressRepository.existsById(spid)){
	// 		this.studentProgressRepository.deleteById(spid);
	// 	}
	// 	else{
	// 		StudentProgress x= new StudentProgress(spid);
	// 		this.studentProgressRepository.save(x);
	// 	}
	// }

	// @GetMapping(value="{sid}/courses")
	// public List<StudentCourseDataDto> getCourses(@PathVariable Long sid) {
	//     Student s1= studentRepository.findById(sid).orElse(null);
	//     System.out.println("Student = " + s1);
	//     List<StudentCourseData> sdata= studentCourseDataRepository.findAllByStudent(s1);
	//     List<StudentCourseDataDto> sDataDtos= new ArrayList<StudentCourseDataDto>();
	//     for (StudentCourseData studentCourseData : sdata) {
	//         long cid = studentCourseData.getCourse().getCourseId();
	//         List<StudentProgress> sprog= this.getStudentProgress(cid, sid);
	//         StudentCourseDataDto sdto= new StudentCourseDataDto(sid, 
	//         cid, 
	//         studentCourseData.getCourse().getCourseName(), 
	//         studentCourseData.getCourse().getTotalLectures(), sprog.size());
	//         sDataDtos.add(sdto);
	//     }
	//     return sDataDtos;
	// }

	// @GetMapping(value="{sid}/courses/{cid}")
	// public Course getCourseById(@PathVariable Long sid, @PathVariable Long cid) {
	//     Course c1= courseRepository.findById(cid).orElse(null);
	//     List<CourseData> cdata= courseDataRepository.findAllByCourse(c1);
	//     c1.setCdata(cdata);
	//     return c1;
	// }
	
	// public List<StudentProgress> getStudentProgress(long cid, long sid){
	//     List<StudentProgress> sp= studentProgressRepository.findAll();
	//     List<StudentProgress> sprog= sp.stream()
	//                                     .filter(x -> 
	//                                         x.getCourse().getCourseId() == cid 
	//                                         && 
	//                                         x.getStudent().getId() == sid)
	//                                     .toList();
	//     return sprog;
	// }
}
