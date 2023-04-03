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
    //     return new BCryptPasswordEncoder();
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
                    .firstName("scam").build();
            studentRepo.save(s1);

            Admin a1 = Admin.adminBuilder()
                    .username("admin")
                    .password("{noop}admin")
                    .role(Role.ADMIN)
                    .firstName("Admin").build();
            adminRepo.save(a1);

            Teacher t1 = Teacher.teacherBuilder()
                    .username("prof")
                    .password("{noop}prof")
                    //.password(encoder().encode("prof"))
                    .role(Role.PROFESSOR)
                    .firstName("Proffesor").build();
            teacherRepo.save(t1);           

            CalenderItem cal = CalenderItem.builder().startDate("2023-04-03")
            .endDate("2023-04-10")
            .userId((long)1)
            .task("Complete Project")
            .build();

            calenderRepository.save(cal);
        }
    }
}
