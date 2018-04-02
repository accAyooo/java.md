package com.study.service;

import com.study.model.Review;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:19 2018/3/11
 */
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        List<Review> database = new ArrayList<>();
        this.getServletContext().setAttribute("DATABASE_LIST", database);
        System.out.println("success");
    }
}
