package com.study.jdbc.servlet;

import com.study.jdbc.bean.User;
import com.study.jdbc.dao.MessageDao;
import com.study.jdbc.service.MessageService;

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
 * @Date: create in 下午11:06 2018/3/31
 */

public class MessageAddServlet extends HttpServlet {
    private MessageService messageService;

    @Override
    public void init() throws ServletException {
        messageService = new MessageService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("LOGIN_USER");

        if (user == null) {
            resp.sendRedirect("/login");
        } else {
            req.getRequestDispatcher("/WEB-INF/views/message-add.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("LOGIN_USER");
        if (user == null) {
            resp.sendRedirect("/login");
        } else {
            String title = req.getParameter("title");
            String content = req.getParameter("content");

            if (title.isEmpty() || content.isEmpty()) {
                req.setAttribute("error", "格式错误");
                req.getRequestDispatcher("/WEB-INF/views/message-add.jsp");
            } else {
                boolean addSuccess = messageService.addMessage(user, title, content);

                if (addSuccess) {
                    resp.sendRedirect("/message/list");
                } else {
                    req.setAttribute("error", "未知错误");
                    req.getRequestDispatcher("/WEB-INF/views/message-add.jsp");
                }
            }
        }
    }
}
