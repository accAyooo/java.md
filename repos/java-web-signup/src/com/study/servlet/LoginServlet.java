package com.study.servlet;

import com.study.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 上午9:57 2018/3/10
 */
@WebServlet("/user/LoginServlet")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        List<User> database = (List<User>) getServletContext().getAttribute("DATABASE_LIST");
        for (User user : database) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                session.setAttribute("LOGIN_USER", user);
            }
        }
        req.getRequestDispatcher("/views/detail.jsp").forward(req,resp);
    }
}
