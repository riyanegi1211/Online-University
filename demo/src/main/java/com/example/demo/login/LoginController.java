package com.example.demo.login;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    private final SecurityContextHolderStrategy securityContextHolderStrategy =
    SecurityContextHolder.getContextHolderStrategy();

    private SecurityContextRepository securityContextRepository = new
    HttpSessionSecurityContextRepository();

    public LoginController(UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("name")
    public String login() {
        return "HI";
    }

    // https://docs.spring.io/spring-security/reference/servlet/authentication/session-management.html#store-authentication-manually
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserLogin userLogin, HttpServletRequest request,
            HttpServletResponse response) { // Authentication authentication
        LOG.info(userLogin.username());
        UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken
                .unauthenticated(userLogin.username(), userLogin.password());
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

    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody UserRegistration userRegistration) {
        LOG.info(userRegistration.username());
        if (userRegistration.username() == null || userRegistration.username().isEmpty()) {
            return new ResponseEntity<>("Username cannot be empty", HttpStatus.BAD_REQUEST);
        }
        else if (userRepository.existsByUsername(userRegistration.username())) {
            return new ResponseEntity<>("Username already exists", HttpStatus.CONFLICT);
        }
        User newUser = User.builder()
                        .username(userRegistration.username())
                        .password(userRegistration.password())
                        .build();
        userRepository.save(newUser);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(Principal principal) {
        LOG.info("Logout : " + principal.getName());
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
