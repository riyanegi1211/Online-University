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
							.totalLectures(18)
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

			CourseData cData3= CourseData.builder()
										.course(c1)
										.title("Lecture 3")
										.link("https://youtu.be/j9RG18jfnRY")
										.build();
			cDataRepository.save(cData3);

			CourseData cData4= CourseData.builder()
										.course(c1)
										.title("Lecture 4")
										.link("https://youtu.be/9rt-hFcXd0M")
										.build();
			cDataRepository.save(cData4);

			CourseData cData5= CourseData.builder()
										.course(c1)
										.title("Lecture 5")
										.link("https://youtu.be/VQVeAQVs1d8")
										.build();
			cDataRepository.save(cData5);

			CourseData cData6= CourseData.builder()
										.course(c1)
										.title("Lecture 6")
										.link("https://youtu.be/dQa4A2Z0_Ro")
										.build();
			cDataRepository.save(cData6);

			CourseData cData7= CourseData.builder()
										.course(c1)
										.title("Lecture 7")
										.link("https://youtu.be/xcPFUCh0jT0")
										.build();
			cDataRepository.save(cData7);

			CourseData cData8= CourseData.builder()
										.course(c1)
										.title("Lecture 8")
										.link("https://youtu.be/Z3dCjzhjAWA")
										.build();
			cDataRepository.save(cData8);

			CourseData cData9= CourseData.builder()
										.course(c1)
										.title("Lecture 9")
										.link("https://youtu.be/3GC83dh4cf0")
										.build();
			cDataRepository.save(cData9);

			CourseData cData10= CourseData.builder()
										.course(c1)
										.title("Lecture 10")
										.link("https://youtu.be/4z9I6ZmeLOQ")
										.build();
			cDataRepository.save(cData10);

			CourseData cData11= CourseData.builder()
										.course(c1)
										.title("Lecture 11")
										.link("https://youtu.be/Dl6HT-NM_q4")
										.build();
			cDataRepository.save(cData11);

			CourseData cData12= CourseData.builder()
										.course(c1)
										.title("Lecture 12")
										.link("https://youtu.be/imqr13aIBAY")
										.build();
			cDataRepository.save(cData12);

			CourseData cData13= CourseData.builder()
										.course(c1)
										.title("Lecture 13")
										.link("https://youtu.be/13ocRMSJy5M")
										.build();
			cDataRepository.save(cData13);

			CourseData cData14= CourseData.builder()
										.course(c1)
										.title("Lecture 14")
										.link("https://youtu.be/C46QfTjVCNU")
										.build();
			cDataRepository.save(cData14);

			CourseData cData15= CourseData.builder()
										.course(c1)
										.title("Lecture 15")
										.link("https://youtu.be/9HlbVEVt_Y0")
										.build();
			cDataRepository.save(cData15);

			CourseData cData16= CourseData.builder()
										.course(c1)
										.title("Lecture 16")
										.link("https://youtu.be/W8hPsBquD6Y")
										.build();
			cDataRepository.save(cData16);

			CourseData cData17= CourseData.builder()
										.course(c1)
										.title("Lecture 17")
										.link("https://youtu.be/1pVI0yiEBR8")
										.build();
			cDataRepository.save(cData17);

			CourseData cData18= CourseData.builder()
										.course(c1)
										.title("Lecture 18")
										.link("https://youtu.be/0kfM_YEzR94")
										.build();
			cDataRepository.save(cData18);

		}
	}
}
