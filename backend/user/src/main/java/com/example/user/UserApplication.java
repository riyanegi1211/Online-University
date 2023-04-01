package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	// @Bean
    // public PasswordEncoder encoder() {
    //     return new BCryptPasswordEncoder();
    // }

    // @Component
    // public class DataLoader implements CommandLineRunner {

    //     @Autowired
    //     private StudentRepository studentRepo;

    //     @Autowired
    //     private TeacherRepository teacherRepo;

    //     @Autowired
    //     private AdminRepository adminRepo;

    //     @Autowired
    //     private CourseRepository courseRepository;

    //     @Autowired
    //     private StudentCourseDataRepository studentCourseDataRepository;

    //     @Override
    //     public void run(String... args) throws Exception {

    //         Admin a1 = Admin.adminBuilder()
    //                 .username("admin")
    //                 .password(encoder().encode("admin"))
    //                 .role(Role.ADMIN)
    //                 .firstName("Admin").build();
    //         adminRepo.save(a1);

    //         Teacher t1 = Teacher.teacherBuilder()
    //                 .username("prof")
    //                 .password(encoder().encode("prof"))
    //                 .role(Role.PROFESSOR)
    //                 .firstName("Proffesor").build();
    //         teacherRepo.save(t1);

    //         Student s1 = Student.studentBuilder()
    //                 .username("abc")
    //                 .password(encoder().encode("abc"))
    //                 .role(Role.STUDENT)
    //                 .firstName("scam").build();
    //         studentRepo.save(s1);

    //         // Student s2 = Student.studentBuilder().id(null);

    //         Course c1 = Course.builder()
    //                         .totalLectures(2)
    //                         .courseName("B.Tech")
    //                         .courseCode("2015108")
    //                         .status("pending")
    //                         .teacher(t1)
    //                         .build();
    //         courseRepository.save(c1);

    //         StudentCourseData sd1 = StudentCourseData.builder()
    //                                     .student(s1)
    //                                     .course(c1)
    //                                     .progress(0)
    //                                     .build();
    //         studentCourseDataRepository.save(sd1);             

    //     }
    // }
}
