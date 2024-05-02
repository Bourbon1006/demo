package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CountController {

    @RequestMapping("Count")
    public String Signin() {
        return "count"; // 返回的字符串对应 JSP 文件的名称，比如 my-page.jsp
    }
}