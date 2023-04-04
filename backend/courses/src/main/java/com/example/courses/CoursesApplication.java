package com.example.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.courses.model.Course;
import com.example.courses.model.CourseData;
import com.example.courses.repository.CourseDataRepository;
import com.example.courses.repository.CourseRepository;

@SpringBootApplication
public class CoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursesApplication.class, args);
	}

	@Component
	public class DataLoader implements CommandLineRunner {

		@Autowired
		private CourseRepository courseRepository;

		@Autowired
		private CourseDataRepository cDataRepository;

		@Override
		public void run(String... args) throws Exception {
			System.out.println("Adding data");
			Course c1 = Course.builder()
							.totalLectures(2)
							.courseName("B.Tech")
							.courseCode("2015108")
							.status("pending")
							.build();
			courseRepository.save(c1);

            Course c2 = Course.builder()
							.totalLectures(4)
							.courseName("MBA")
							.courseCode("2015109")
							.status("completed")
							.build();
            courseRepository.save(c2);

			CourseData cData= CourseData.builder()
										.course(c1)
										.title("Lecture 1")
										.link("https://youtu.be/9rt-hFcXd0M")
										.build();
			cDataRepository.save(cData);

			CourseData cData2= CourseData.builder()
										.course(c1)
										.title("Lecture 2")
										.link("https://youtu.be/9rt-hFcXd0M")
										.build();
			cDataRepository.save(cData2);

		}
	}
}
