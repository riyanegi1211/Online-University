package com.example.user;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import com.example.user.model.Course;
import com.example.user.model.CourseList;
import com.example.user.model.CourseSummary;
import com.example.user.model.StudentCourseData;
import com.example.user.model.StudentList;

import reactor.core.publisher.Mono;

@Service
public class EnrollmentService {
    WebClient client = WebClient.create("http://localhost:8082");

    public List<CourseList> getCoursesForId(long userId) {
        UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri("/courses/student/" + String.valueOf(userId));
        RequestHeadersSpec<?> headersSpec = bodySpec;
        Mono<List<CourseList>> response = headersSpec.header(
                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                // .ifNoneMatch("*")
                // .ifModifiedSince(ZonedDateTime.now())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CourseList>>() {
                });

        List<CourseList> val = null;
        try {
            val = response.toFuture().get();
        } catch (NumberFormatException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

    public List<StudentList> getStudentsForCourseId(long courseId) {
        UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri("/student/" + String.valueOf(courseId));
        RequestHeadersSpec<?> headersSpec = bodySpec;
        Mono<List<StudentList>> response = headersSpec.header(
                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                // .ifNoneMatch("*")
                // .ifModifiedSince(ZonedDateTime.now())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<StudentList>>() {
                });

        List<StudentList> val = null;
        try {
            val = response.toFuture().get();
        } catch (NumberFormatException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

    public List<StudentCourseData> getStudentCourseData(long userId, long courseId) {
        UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri("/courses/" + courseId + "/student/" + userId + "/attendance");
        RequestHeadersSpec<?> headersSpec = bodySpec;
        Mono<List<StudentCourseData>> response = headersSpec.header(
                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                // .ifNoneMatch("*")
                // .ifModifiedSince(ZonedDateTime.now())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<StudentCourseData>>() {
                });

        List<StudentCourseData> val = null;
        try {
            val = response.toFuture().get();
        } catch (NumberFormatException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

    public String uploadFile(long userId, long courseId, MultipartFile file) {
        UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.POST);
        RequestBodySpec bodySpec = uriSpec.uri("/student/" + userId + "/courses/" + courseId + "/upload");
        bodySpec.bodyValue(file);
        RequestHeadersSpec<?> headersSpec = bodySpec;
        Mono<String> response = headersSpec.header(
                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                // .ifNoneMatch("*")
                // .ifModifiedSince(ZonedDateTime.now())
                .retrieve()
                .bodyToMono(String.class);
        String val = "";
        try {
            val = response.toFuture().get();
        } catch (NumberFormatException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

    public List<String> getFileNames(long userId, long courseId) {
        UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri("/student/" + userId + "/courses/" + courseId + "/files");
        RequestHeadersSpec<?> headersSpec = bodySpec;
        Mono<List<String>> response = headersSpec.header(
                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                // .ifNoneMatch("*")
                // .ifModifiedSince(ZonedDateTime.now())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {
                });
        List<String> val = null;
        try {
            val = response.toFuture().get();
        } catch (NumberFormatException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }
}
