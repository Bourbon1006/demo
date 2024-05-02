package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring Boot中支持jsp功能的实现
 */
@Controller
public class JspController {

    @RequestMapping("/index")
    public String index() {
        //要跳转到的页面视图名称
        return "index";
    }

}
