package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class qw {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
