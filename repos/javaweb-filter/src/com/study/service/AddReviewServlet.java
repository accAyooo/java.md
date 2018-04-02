package com.study.service;

import com.study.model.Review;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:17 2018/3/11
 */
@WebServlet("/user/AddReviewServlet")
public class AddReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        List<Review> database = (List<Review>) getServletContext().getAttribute("DATABASE_LIST");

        if (title != null && content != null) {
            Review review = new Review();
            review.setContent(content);
            review.setTitle(title);
            database.add(review);
            this.getServletContext().setAttribute("DATABASE_LIST", database);
            req.setAttribute("reviewList", database);
        } else {
            req.setAttribute("message", "输入有误");
        }
        req.getRequestDispatcher("/views/add.jsp").forward(req, resp);
    }
}
