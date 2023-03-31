package com.example.gateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class LoginController {

    @PostMapping("/api/login")
    public Mono<String> myEndpoint(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.OK);
        return Mono.just("Successful");
    }
}