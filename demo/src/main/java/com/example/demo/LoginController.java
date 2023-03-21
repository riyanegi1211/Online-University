package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class LoginController {
    @GetMapping(value="login")
    public String getMethodName() { // @PathVariable String name
        // if (!"admin".equals(name)) {
        //     return "Failure";
        // }
        return "Success";
    }
    
}
