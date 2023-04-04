package com.example.user;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
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
import com.example.user.model.CourseList;
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
    public List<CourseList> getCourses(long userId) {
        return enrollmentService.getCoursesForId(userId);
    }

    public List<Course> getAllCourses() {
        UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri("/courses");
        RequestHeadersSpec<?> headersSpec = bodySpec;
        Mono<List<Course>> response = headersSpec.header(
                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                // .ifNoneMatch("*")
                // .ifModifiedSince(ZonedDateTime.now())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Course>>() {
                });

        List<Course> val = null;
        try {
            val = response.toFuture().get();
        } catch (NumberFormatException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

    // course service and enrollment
    public CourseStudent getCourseByIdWithData(long userId, long courseId) {
        Course c = this.getCourseById(userId, courseId);
        // c.setTotalLectures(c.getCourseData().size());
        List<StudentCourseData> data = enrollmentService.getStudentCourseData(userId, courseId);
        
        CourseStudent cs = CourseStudent.builder()
                                .studentCourseData(data)
                                .attendedLectures(data.size())
                                .course(c)
                                .progress((Integer)((data.size())/(c.getTotalLectures())*100))
                                .build();
        return cs;
    }

    // course service
    public Course getCourseById(long userId, long courseId) {
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

    public List<CourseStudent> getCoursesHome(long sid) {
        List<CourseList> clist= this.enrollmentService.getCoursesForId(sid);
        List<CourseStudent> lcourse= new ArrayList<>();
        for(CourseList cList2: clist){
            lcourse.add(this.getCourseByIdWithData(sid, cList2.getCourseId()));
        }
        return lcourse;
    }

    public String saveCourses(Course course) {
        UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.POST);
        RequestBodySpec bodySpec = uriSpec.uri("/courses");
        bodySpec.bodyValue(course);
        RequestHeadersSpec<?> headersSpec = bodySpec;
        Mono<String> response = headersSpec.header(
                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                // .ifNoneMatch("*")
                // .ifModifiedSince(ZonedDateTime.now())
                .retrieve()
                .bodyToMono(String.class);
        String val="";
        try {
            val = response.toFuture().get();
        } catch (NumberFormatException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

    public String updateCourses(Course course, Long cid) {
        UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.PUT);
        RequestBodySpec bodySpec = uriSpec.uri("/courses/"+cid);
        bodySpec.bodyValue(course);
        RequestHeadersSpec<?> headersSpec = bodySpec;
        Mono<String> response = headersSpec.header(
                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                // .ifNoneMatch("*")
                // .ifModifiedSince(ZonedDateTime.now())
                .retrieve()
                .bodyToMono(String.class);
        String val="";
        try {
            val = response.toFuture().get();
        } catch (NumberFormatException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

    public String deleteCourse(Long cid) {
        UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.DELETE);
        RequestBodySpec bodySpec = uriSpec.uri("/courses/"+cid);
        // bodySpec.bodyValue(course);
        RequestHeadersSpec<?> headersSpec = bodySpec;
        Mono<String> response = headersSpec.header(
                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                // .ifNoneMatch("*")
                // .ifModifiedSince(ZonedDateTime.now())
                .retrieve()
                .bodyToMono(String.class);
        String val="";
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
