package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.user.Role;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepo) {
		User u1 = User.builder()
                        .username("admin")
                        .password(encoder().encode("admin"))
                        .role(Role.ADMIN)
                        .build();
        User u2 = User.builder()
                        .username("prof")
                        .password(encoder().encode("prof"))
                        .role(Role.PROFESSOR)
                        .build();
        User u3 = User.builder()
                        .username("abc")
                        .password(encoder().encode("abc"))
                        .role(Role.STUDENT)
                        .build();
		return args -> {
			userRepo.save(u1);
			userRepo.save(u2);
			userRepo.save(u3);
		};
	}
}
