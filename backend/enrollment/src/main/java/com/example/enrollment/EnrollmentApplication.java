package com.example.enrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.enrollment.model.Enrollment;
import com.example.enrollment.repository.EnrollmentRepository;

@SpringBootApplication
public class EnrollmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnrollmentApplication.class, args);
	}

	@Component
	public class DataLoader implements CommandLineRunner {

		@Autowired
		private EnrollmentRepository enrollmentRepository;

		@Override
		public void run(String... args) throws Exception {
			System.out.println("Adding data");
			Enrollment e = Enrollment.builder()
									.courseId(1)
									.userId(1)
									.build();
			enrollmentRepository.save(e);

            Enrollment e2 = Enrollment.builder()
									.courseId(2)
									.userId(1)
									.build();
			enrollmentRepository.save(e2);
		}
	}

}
