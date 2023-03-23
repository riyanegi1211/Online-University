package com.example.demo.login;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.Role;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserRepository userRepository;

    // public LoginController(@Autowired UserRepository userRepository) {
    //     this.userRepository = userRepository;
    // }

    // @PostMapping("/login")
    // public String login(@RequestParam("username") String username,
    //         @RequestParam("password") String password,
    //         @RequestParam("email") String email,
    //         @RequestParam("role") Role role) {
    //     User user = new User();
    //     user.setUsername(username);
    //     user.setPassword(password);
    //     // user.setEmail(email);
    //     user.setRole(role);

    //     userRepository.save(user);

    //     return "redirect:/login";
    // }

    @PostMapping("/login")
    public String login(Authentication authentication) {
        LOG.info(authentication.getName());
        return "Hi";
    }

    // @PostMapping("/register")
    // public String registerNewUser(@RequestParam("username") String username,
    //         @RequestParam("password") String password,
    //         @RequestParam("email") String email,
    //         @RequestParam("role") Role role) {
    //     User user = new User();
    //     user.setUsername(username);
    //     user.setPassword(password);
    //     // user.setEmail(email);
    //     user.setRole(role);

    //     userRepository.save(user);

    //     return "redirect:/login";
    // }

    // @GetMapping(value="login/{name}")
    // public String getMethodName(@PathVariable String name) {
    // if ("admin".equals(name)) {
    // return "Success";
    // }
    // return "Failure";
    // }

    @GetMapping(value="/")
    public String home() {
    return "Home View";
    }

    @GetMapping(value="/name")
    public String getName() {
    return "Shalabh";
    }

    @GetMapping(value="admin")
    public String adminView() {
    return "Admin View";
    }

    @GetMapping(value="student")
    public String studentView() {
    return "Student View";
    }
}
