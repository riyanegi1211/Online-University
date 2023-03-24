package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.model.Admin;
import com.example.demo.model.Role;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Component
    public class DataLoader implements CommandLineRunner {

        @Autowired
        private StudentRepository studentRepo;

        @Autowired
        private TeacherRepository teacherRepo;

        @Autowired
        private AdminRepository adminRepo;

        @Override
        public void run(String... args) throws Exception {
            // User u1 = User.builder()
            //         .username("admin")
            //         .password(encoder().encode("admin"))
            //         .role(Role.ADMIN)
            //         .build();
            // User u2 = User.builder()
            //         .username("prof")
            //         .password(encoder().encode("prof"))
            //         .role(Role.PROFESSOR)
            //         .build();
            // User u3 = User.builder()
            //         .username("abc")
            //         .password(encoder().encode("abc"))
            //         .role(Role.STUDENT)
            //         .build();
            // userRepo.save(u1);
            // userRepo.save(u2);
            // userRepo.save(u3);

            Admin a1 = Admin.adminBuilder()
                    .username("admin")
                    .password(encoder().encode("admin"))
                    .role(Role.ADMIN)
                    .firstName("Admin").build();
            adminRepo.save(a1);

            Teacher t1 = Teacher.teacherBuilder()
                    .username("prof")
                    .password(encoder().encode("prof"))
                    .role(Role.PROFESSOR)
                    .firstName("Proffesor").build();
            teacherRepo.save(t1);

            Student s1 = Student.studentBuilder()
                    .username("abc")
                    .password(encoder().encode("abc"))
                    .role(Role.STUDENT)
                    .firstName("scam").build();
            studentRepo.save(s1);
        }
    }
}
