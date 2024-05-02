package com.example.demo.controller;

import com.example.demo.UserCredentials;
import com.example.demo.data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginController {

    @PostMapping("/checkCredentials")
    public boolean checkCredentials(@RequestBody UserCredentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        // 调用 data.java 中的方法验证用户名和密码
        return data.checkCredentials(username, password);
    }
    /*public static void main(String[] args) {
        String url = "http://localhost:8080/checkCredentials";
        UserCredentials credentials = new UserCredentials("abc", "123456");

        RestTemplate restTemplate = new RestTemplate();
        boolean result = Boolean.TRUE.equals(restTemplate.postForObject(url, credentials, Boolean.class));

        System.out.println("Authentication result: " + result);
    }*/
}

