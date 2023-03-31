package com.example.user;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import com.example.user.model.Course;
import com.example.user.model.CourseSummary;
import com.example.user.model.StudentCourseData;

import reactor.core.publisher.Mono;

@Service
public class EnrollmentService {
    WebClient client = WebClient.create("http://localhost:8082");

    public List<CourseSummary> getCourses(long userId) {
        UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri("/courses/" + String.valueOf(userId));
        RequestHeadersSpec<?> headersSpec = bodySpec;
        Mono<List<CourseSummary>> response = headersSpec.header(
                HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                // .ifNoneMatch("*")
                // .ifModifiedSince(ZonedDateTime.now())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CourseSummary>>() {
                });

        List<CourseSummary> val = null;
        try {
            val = response.toFuture().get();
        } catch (NumberFormatException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

    public List<StudentCourseData> getStudentCourseData(long userId, int courseId) {
        UriSpec<RequestBodySpec> uriSpec = this.client.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri("/courses/" + String.valueOf(userId)+"/data");
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

}
