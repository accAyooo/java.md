package com.study.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:00 2018/3/11
 */

@WebServlet("/user/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("admin") && password.equals("admin")) {
            req.getRequestDispatcher(req.getContextPath() + "/views/add.jsp").forward(req, resp);
        }
        req.setAttribute("message", "用户名或密码错误");
        req.getRequestDispatcher(req.getContextPath() + "/login.jsp").forward(req, resp);
    }
}
