// package com.example.gateway;

// import java.util.Arrays;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
// import org.springframework.security.config.web.server.ServerHttpSecurity;
// import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// // import org.springframework.security.core.userdetails.UserDetailsService;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // import org.springframework.security.crypto.password.PasswordEncoder;
// // import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.server.SecurityWebFilterChain;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.reactive.CorsConfigurationSource;
// import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

// @Configuration
// @EnableWebFluxSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//         return http
//                 .authorizeExchange()
//                 // .pathMatchers("/api/login/").permitAll()
//                 // .pathMatchers("/api/role/").permitAll()
//                 // .pathMatchers("/api/student/**").permitAll()
//                 .anyExchange().authenticated()
//                 // .pathMatchers("/**").authenticated()
//                 .and()
//                 .httpBasic(Customizer.withDefaults())
//                 .csrf().disable()
//                 // .cors() // Customizer.withDefaults()
//                 .build();
//     }

//     @Bean
//     CorsConfigurationSource corsConfigurationSource() {
//         CorsConfiguration configuration = new CorsConfiguration();
//         configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); 
//         configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
//         configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//         configuration.setAllowCredentials(true);
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration("/**", configuration);
//         return source;
//     }

//     // @Bean
//     // public PasswordEncoder encoder() {
//     // return new BCryptPasswordEncoder();
//     // }

//     /*
//      * {
//      * "username":"admin",
//      * "password":"admin"
//      * }
//      */

//     @Bean
//     public MapReactiveUserDetailsService userDetailsService() {
//         // System.out.println("{bcrypt}" + encoder().encode("admin"));
//         UserDetails u1 = User
//                 .withUsername("admin")
//                 .password("{noop}admin") // encoder().encode(
//                 .authorities("ADMIN")
//                 .build();

//         UserDetails u2 = User
//                 .withUsername("prof")
//                 .password("{noop}prof")
//                 .authorities("PROF")
//                 .build();

//         UserDetails u3 = User
//                 .withUsername("abc")
//                 .password("{noop}abc")
//                 .authorities("STUDENT")
//                 .build();
//         return new MapReactiveUserDetailsService(u1, u2, u3);
//     }

// }
