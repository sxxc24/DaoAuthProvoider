package com.userpassword.security.controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo(HttpServletRequest request) {
        return "spring Security "+request.getSession().getId();
    }
}
