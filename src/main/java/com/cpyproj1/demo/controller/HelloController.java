package com.cpyproj1.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Step 20 - Configuring the Spring Boot Application

    // @Value("${welcome.message}")
    // @Autowired
    // private String welcomeMessage;


    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }


    
}
