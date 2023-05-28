package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.user.model.Admin;
import com.example.user.model.CalenderItem;
import com.example.user.model.Role;
import com.example.user.model.Student;
import com.example.user.model.Teacher;
import com.example.user.repository.AdminRepository;
import com.example.user.repository.CalenderRepository;
import com.example.user.repository.StudentRepository;
import com.example.user.repository.TeacherRepository;

@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
    // @Bean
    // public PasswordEncoder encoder() {
    // return new BCryptPasswordEncoder();
    // }

    @Component
    public class DataLoader implements CommandLineRunner {

        @Autowired
        private StudentRepository studentRepo;

        @Autowired
        private TeacherRepository teacherRepo;

        @Autowired
        private AdminRepository adminRepo;

        @Autowired
        private CalenderRepository calenderRepository;

        @Override
        public void run(String... args) throws Exception {

            Student s1 = Student.studentBuilder()
                    .username("abc")
                    .password("{noop}abc")
                    .role(Role.STUDENT)
                    .firstName("scam")
                    .lastName("1992")
                    .studentSemester(Long.valueOf(6))
                    .studentBranch("B.Tech")
                    .studentId("2015108")
                    .build();
            studentRepo.save(s1);

            Student s2 = Student.studentBuilder()
                    .username("abc2")
                    .password("{noop}abc2")
                    .role(Role.STUDENT)
                    .firstName("scam")
                    .lastName("1992")
                    .studentSemester(Long.valueOf(4))
                    .studentBranch("MBA")
                    .studentId("2015108")
                    .build();
            studentRepo.save(s2);

            Student s3 = Student.studentBuilder()
                    .username("abc3")
                    .password("{noop}abc3")
                    .role(Role.STUDENT)
                    .firstName("scam")
                    .lastName("1992")
                    .studentSemester(Long.valueOf(7))
                    .studentBranch("MCA")
                    .studentId("2015108")
                    .build();
            studentRepo.save(s3);

            Student s4 = Student.studentBuilder()
                    .username("abc4")
                    .password("{noop}abc4")
                    .role(Role.STUDENT)
                    .firstName("scam")
                    .lastName("1992")
                    .studentSemester(Long.valueOf(6))
                    .studentBranch("B.Tech")
                    .studentId("2015108")
                    .build();
            studentRepo.save(s4);

            Admin a1 = Admin.adminBuilder()
                    .username("admin")
                    .password("{noop}admin")
                    .role(Role.ADMIN)
                    .firstName("Admin").build();
            adminRepo.save(a1);

            Teacher t1 = Teacher.teacherBuilder()
                    .username("prof")
                    .password("{noop}prof")
                    // .password(encoder().encode("prof"))
                    .role(Role.PROFESSOR)
                    .firstName("Proffesor").build();
            teacherRepo.save(t1);

            CalenderItem cal = CalenderItem.builder()
                    .startDate("2023-05-27")
                    .endDate("2023-05-30")
                    .userId((long) 1)
                    .task("Complete Project")
                    .build();

            calenderRepository.save(cal);
        }
    }
}
