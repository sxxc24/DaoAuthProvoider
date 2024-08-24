package com.userpassword.security.controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private UserRepp repo;
    
    @GetMapping("/demo")
    public String demo(HttpServletRequest request) {
        return "spring Security "+request.getSession().getId();
    }
    @PostMapping("/adduser")
    public String adduser(@RequestBody DemoUser user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10); // 2^10
        user.setPassword(encoder.encode(user.getPassword())); // hashed and saved to db
        repo.save(user);
        return user.toString();
    }
}
