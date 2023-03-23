package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public AuthenticationManager authManager(UserDetailsService userDetailsService) {
        var authProvider = new DaoAuthenticationProvider();
        authProvider.
        return null;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // .cors().disable()
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> {
                    // authz.requestMatchers("/").permitAll();
                    authz.requestMatchers("/favicon.ico").permitAll();
                    authz.requestMatchers("/error").permitAll();
                    // authz.requestMatchers("/login").permitAll();
                    // authz.requestMatchers("/register").permitAll();
                    authz.anyRequest().authenticated();
                })
                .authenticationProvider(new TestAuthenticationProvider())
                // .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                // .sessionManagement()
                // .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                // .userDetailsService(null)
                // .formLogin(Customizer.withDefaults())
                // .httpBasic(Customizer.withDefaults())
                .build();
    }

    // @Bean
    // public PasswordEncoder encoder() {
    //     return new BCryptPasswordEncoder();
    // }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     return new InMemoryUserDetailsManager(
    //             User.builder()
    //                     .username("admin")
    //                     .password(encoder().encode("admin"))
    //                     .roles("ADMIN")
    //                     .build());
    // }
}
