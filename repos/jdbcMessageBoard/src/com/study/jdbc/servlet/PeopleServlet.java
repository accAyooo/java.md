package com.study.jdbc.servlet;

import com.study.jdbc.bean.User;
import com.study.jdbc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午11:48 2018/3/31
 */
@WebServlet("/people")
public class PeopleServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("LOGIN_USER");
        if (user == null){
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/views/people.jsp").forward(req, resp);
        }
    }
}
