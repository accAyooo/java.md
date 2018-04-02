package com.study.servlet;

import com.study.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 上午9:42 2018/3/10
 */
public class InitServlet extends HttpServlet {
    private List<User> database;
    @Override
    public void init() throws ServletException {
        this.database = new ArrayList<>();
        getServletContext().setAttribute("DATABASE_LIST", database);
    }
}
