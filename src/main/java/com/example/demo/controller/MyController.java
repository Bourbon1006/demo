package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/Signin")
    public String Signin() {
        return "Signin"; // 返回的字符串对应 JSP 文件的名称，比如 my-page.jsp
    }
}
