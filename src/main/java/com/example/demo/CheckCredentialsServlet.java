package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkCredentials")
public class CheckCredentialsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 调用 checkCredentials 方法检查用户名和密码是否匹配
        boolean result = data.checkCredentials(username, password);

        // 返回验证结果给前端
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
    }
}
