package com.example.gateway;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class LoginController {

    @PostMapping("/api/login")
    public Mono<String> myEndpoint(ServerHttpResponse response) {
        // System.out.println("Message from Login");
        // response.setStatusCode(HttpStatus.OK);
        return Mono.just("Successful");
    }

    @GetMapping("/api/role")
    public Mono<String> getRole(ServerHttpResponse response, Authentication auth) {
        // System.out.println("Message from Login");
        // response.setStatusCode(HttpStatus.OK);
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        List<String> roles = new ArrayList<>();
    
        for (GrantedAuthority authority : authorities) {
            roles.add(authority.getAuthority());
        }

        if (roles.isEmpty()) {
            return Mono.just("None");
        }
        
        return Mono.just(roles.get(0));
    }
}