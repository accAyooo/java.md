package com.study.code;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午11:09 2018/3/13
 */

@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputValue = req.getParameter("code");
        String codeValue = (String) req.getSession().getAttribute("code");

        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        if (codeValue.equals(inputValue)) {
            resp.getWriter().write("<h1>登录成功</h1>");
        } else
            resp.getWriter().write("<h1 style='color:red'>登录失败</h1>");
    }
}
