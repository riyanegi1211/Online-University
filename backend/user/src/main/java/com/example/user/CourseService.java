package com.example.user;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import com.example.user.model.Course;
import com.example.user.model.CourseData;
import com.example.user.model.CourseStudent;
import com.example.user.model.CourseSummary;
import com.example.user.model.StudentCourseData;

import reactor.core.publisher.Mono;

@Service
public class CourseService {

    WebClient client = WebClient.create("http://localhost:8081");

    @Autowired
    private EnrollmentService enrollmentService;

    // enrollment ?course service
    public List<CourseSummary> getCourses(long userId) {
        return enrollmentService.getCourses(userId);
    }

    // course service and enrollment
    public CourseStudent getCourseByIdStudent(long userId, int courseId) {
        Course c = this.getCourseById(userId, courseId);
        List<StudentCourseData> data = enrollmentService.getStudentCourseData(userId, courseId);
        CourseStudent cs = CourseStudent.builder()
                                .studentCourseData(data)
                                .courseData(c.getCourseData())
                                .courseId(c.getCourseId())
                                .description(c.getDescription())
                                .title(c.getTitle())
                                .build();
        return cs;
    }

    // course service
    public Course getCourseById(long userId, int courseId) {
        UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri("/courses/" + String.valueOf(courseId));
        RequestHeadersSpec<?> headersSpec = bodySpec;
        Mono<Course> response = headersSpec.header(
                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                // .ifNoneMatch("*")
                // .ifModifiedSince(ZonedDateTime.now())
                .retrieve()
                .bodyToMono(Course.class);

        Course val = null;
        try {
            val = response.toFuture().get();
        } catch (NumberFormatException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

    // course service
    public CourseData getCourseDataById(long userId, int courseId, int dataId) {
        UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri("/courses/" + String.valueOf(courseId) + "/" + String.valueOf(dataId));
        RequestHeadersSpec<?> headersSpec = bodySpec;
        Mono<CourseData> response = headersSpec.header(
                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                // .ifNoneMatch("*")
                // .ifModifiedSince(ZonedDateTime.now())
                .retrieve()
                .bodyToMono(CourseData.class);

        CourseData val = null;
        try {
            val = response.toFuture().get();
        } catch (NumberFormatException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

    // SO71077603
    // public Long test() {
    //     System.out.println("Inside Test");
    //     UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.GET);
    //     // get();
    //     RequestBodySpec bodySpec = uriSpec.uri("/3");
    //     RequestHeadersSpec<?> headersSpec = bodySpec;
    //     // ResponseSpec responseSpec
    //     Mono<String> response = headersSpec.header(
    //             HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    //             .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
    //             .acceptCharset(StandardCharsets.UTF_8)
    //             // .ifNoneMatch("*")
    //             // .ifModifiedSince(ZonedDateTime.now())
    //             .retrieve()
    //             .bodyToMono(String.class);

    //     long val = -1;
    //     System.out.println("intial value of val = " + val);
    //     try {
    //         val = Long.parseLong(response.toFuture().get());
    //     } catch (NumberFormatException | InterruptedException | ExecutionException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    //     System.out.println("final value of val = " + val);
    //     return val;
    // }
}
