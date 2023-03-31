package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

import com.example.demo.service.JpaUserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JpaUserDetailsService jpaUserDetailsService;

    public SecurityConfig(JpaUserDetailsService jpaUserDetailsService) {
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/login").permitAll()
                        .requestMatchers("/api/register").permitAll()
                        .requestMatchers("/api/logout").permitAll()
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/student/**").hasRole("STUDENT")
                        .requestMatchers("/api/prof/**").hasRole("PROFESSOR")
                        .anyRequest().authenticated())
                .logout(logout -> logout
                        .logoutUrl("/api/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll())
                // .headers(headers -> headers.frameOptions().sameOrigin())
                .headers(headers -> headers
                    .frameOptions().sameOrigin()
                    .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Credentials", "true"))
                    .addHeaderWriter(new StaticHeadersWriter(" Access-Control-Allow-Origin", "http://localhost:4200"))
                )
                .build();
    }

    @Bean
    public AuthenticationManager authManager(JpaUserDetailsService jpaUserDetailsService) {
        var authProvider = new DaoAuthenticationProvider();
        PasswordEncoder bcrypt = new BCryptPasswordEncoder();
        authProvider.setPasswordEncoder(bcrypt);
        authProvider.setUserDetailsService(this.jpaUserDetailsService);
        return new ProviderManager(authProvider);
    }
}
