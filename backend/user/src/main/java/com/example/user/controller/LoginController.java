package com.example.user.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.Role;
import com.example.user.model.User;
import com.example.user.model.UserLogin;
// import com.example.user.model.UserRegistration;
import com.example.user.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.security.Principal;
// import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    private final SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder
            .getContextHolderStrategy();

    private SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();

    public LoginController(UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("role")
    public String login(Authentication authentication) {
        List<String> roles = new ArrayList<>();
        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                roles.add(authority.getAuthority());
            }
            // roles list now contains the names of all roles the user has
        }
        return String.join(",", roles);
    }

    // https://docs.spring.io/spring-security/reference/servlet/authentication/session-management.html#store-authentication-manually
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserLogin userLogin, HttpServletRequest request,
            HttpServletResponse response) { // Authentication authentication
        LOG.info(userLogin.getUsername());
        UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken
                .unauthenticated(userLogin.getUsername(), userLogin.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);

        SecurityContext context = securityContextHolderStrategy.createEmptyContext();
        context.setAuthentication(authentication);
        securityContextHolderStrategy.setContext(context);
        securityContextRepository.saveContext(context, request, response);

        if (authentication.isAuthenticated() == false) {
            return new ResponseEntity<>("Failed", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

    // @PostMapping("register")
    // public ResponseEntity<String> registerNewUser(@RequestBody UserRegistration
    // userRegistration) {
    // LOG.info(userRegistration.username());
    // if (userRegistration.username() == null ||
    // userRegistration.username().isEmpty()) {
    // return new ResponseEntity<>("Username cannot be empty",
    // HttpStatus.BAD_REQUEST);
    // } else if (userRepository.existsByUsername(userRegistration.username())) {
    // return new ResponseEntity<>("Username already exists", HttpStatus.CONFLICT);
    // }

    // PasswordEncoder encoder = new BCryptPasswordEncoder();

    // User newUser = User.builder()
    // .username(userRegistration.username())
    // .password(encoder.encode(userRegistration.password()))
    // .role(Role.GUEST)
    // .build();
    // userRepository.save(newUser);
    // return new ResponseEntity<>("Success", HttpStatus.CREATED);
    // }

    // It works, just returns 403 instead of 200
    @PostMapping("logout")
    public ResponseEntity<String> logout(Principal principal) {
        if (principal != null) {
            LOG.info("Logout : " + principal.getName());
        }
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}

// package com.example.user.controller;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.user.model.User;
// import com.example.user.model.UserIdentifier;
// import com.example.user.model.UserLogin;
// import com.example.user.repository.UserRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// @RestController
// @RequestMapping("login")
// public class LoginController {

// @Autowired
// private UserRepository userRepository;

// @PostMapping
// public UserIdentifier login(@RequestBody UserLogin user) {
// System.out.println(user);
// User u = userRepository.findByUsername(user.getUsername()).orElse(null);
// if (u != null && u.getPassword().equals("{noop}"+user.getPassword())) {
// return new UserIdentifier(u.getId(), u.getRole().toString());
// }
// return new UserIdentifier();
// }

// }
