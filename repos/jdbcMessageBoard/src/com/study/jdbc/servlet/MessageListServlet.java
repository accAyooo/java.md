package com.study.jdbc.servlet;

import com.study.jdbc.bean.Message;
import com.study.jdbc.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午4:09 2018/3/31
 */
public class MessageListServlet extends HttpServlet {

    private MessageService messageService;

    @Override
    public void init() throws ServletException {
        messageService = new MessageService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pmPage = req.getParameter("page");
        int page = 1;
        if (pmPage != null) {
            try{
                page = Integer.parseInt(pmPage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List<Message> messages = messageService.getMessages(page, 5);

        int count = messageService.totalCount();
        int lastPage = count % 5 == 0 ? (count / 5) : (count / 5 + 1);

        req.setAttribute("messages", messages);
        req.setAttribute("last", lastPage);
        req.setAttribute("page", page);

        req.getRequestDispatcher("/WEB-INF/views/message-list.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        messageService = null;
    }
}
