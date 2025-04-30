package com.example.jwt.pjt.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiCtrl {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("debug >>>> api hello 요청됨");
        return "Hello, User!";
    }
}
