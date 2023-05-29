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
							.totalLectures(34)
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

            Course c3 = Course.builder()
							.totalLectures(5)
							.courseName("BioTech")
							.courseCode("20151055")
							.status("completed")
							.build();
            courseRepository.save(c3);

            Course c4 = Course.builder()
							.totalLectures(6)
							.courseName("BCA")
							.courseCode("2015012")
							.status("completed")
							.build();
            courseRepository.save(c4);

            Course c5 = Course.builder()
							.totalLectures(7)
							.courseName("MCA")
							.courseCode("2014114")
							.status("completed")
							.build();
            courseRepository.save(c5);

            Course c6 = Course.builder()
							.totalLectures(8)
							.courseName("B.Pharma")
							.courseCode("2014025")
							.status("completed")
							.build();
            courseRepository.save(c6);

            Course c7 = Course.builder()
							.totalLectures(9)
							.courseName("LLM")
							.courseCode("2013886")
							.status("completed")
							.build();
            courseRepository.save(c7);

            Course c8 = Course.builder()
							.totalLectures(14)
							.courseName("MBBS")
							.courseCode("2014732")
							.status("completed")
							.build();
            courseRepository.save(c8);

			// Course 1 Unit 1 
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

			// Course 1 Unit 2
			CourseData cData19= CourseData.builder()
										.course(c1)
										.title("Lecture 19")
										.link("https://youtu.be/MiJdgxTWaFs")
										.build();
			cDataRepository.save(cData19);

			CourseData cData20= CourseData.builder()
										.course(c1)
										.title("Lecture 20")
										.link("https://youtu.be/s8l8NWII3qw")
										.build();
			cDataRepository.save(cData20);

			CourseData cData21= CourseData.builder()
										.course(c1)
										.title("Lecture 21")
										.link("https://youtu.be/WEpLyOc0bCE")
										.build();
			cDataRepository.save(cData21);

			CourseData cData22= CourseData.builder()
										.course(c1)
										.title("Lecture 22")
										.link("https://youtu.be/eJcBH0xvG98")
										.build();
			cDataRepository.save(cData22);

			CourseData cData23= CourseData.builder()
										.course(c1)
										.title("Lecture 23")
										.link("https://youtu.be/kJW_iXrwePE")
										.build();
			cDataRepository.save(cData23);

			CourseData cData24= CourseData.builder()
										.course(c1)
										.title("Lecture 24")
										.link("https://youtu.be/7F3MYyw3Jmg")
										.build();
			cDataRepository.save(cData24);

			CourseData cData25= CourseData.builder()
										.course(c1)
										.title("Lecture 25")
										.link("https://youtu.be/Xx1tWbb37hY")
										.build();
			cDataRepository.save(cData25);

			CourseData cData26= CourseData.builder()
										.course(c1)
										.title("Lecture 26")
										.link("https://youtu.be/xKZFAkSt2UU")
										.build();
			cDataRepository.save(cData26);

			CourseData cData27= CourseData.builder()
										.course(c1)
										.title("Lecture 27")
										.link("https://youtu.be/TkTgo_7ab0M")
										.build();
			cDataRepository.save(cData27);

			CourseData cData28= CourseData.builder()
										.course(c1)
										.title("Lecture 28")
										.link("https://youtu.be/Crqgl10aIGQ")
										.build();
			cDataRepository.save(cData28);

			CourseData cData29= CourseData.builder()
										.course(c1)
										.title("Lecture 29")
										.link("https://youtu.be/kvk8gfAJLeg")
										.build();
			cDataRepository.save(cData29);

			CourseData cData30= CourseData.builder()
										.course(c1)
										.title("Lecture 30")
										.link("https://youtu.be/bjtMCwy_LMA")
										.build();
			cDataRepository.save(cData30);
			CourseData cData31= CourseData.builder()
										.course(c1)
										.title("Lecture 31")
										.link("https://youtu.be/LCRGV8avvUY")
										.build();
			cDataRepository.save(cData31);

			CourseData cData32= CourseData.builder()
										.course(c1)
										.title("Lecture 32")
										.link("https://youtu.be/Fj1ywT9ETQk")
										.build();
			cDataRepository.save(cData32);

			CourseData cData33= CourseData.builder()
										.course(c1)
										.title("Lecture 33")
										.link("https://youtu.be/c_dqAyQu84A")
										.build();
			cDataRepository.save(cData33);

			CourseData cData34= CourseData.builder()
										.course(c1)
										.title("Lecture 34")
										.link("https://youtu.be/1t8NAjIXvVA")
										.build();
			cDataRepository.save(cData34);
		}
	}
}
