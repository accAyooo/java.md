package com.study.SSO.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午9:36 2018/3/14
 */
public class LoginServlet extends HttpServlet {
    private String domains;

    @Override
    public void init(ServletConfig config) throws ServletException {
        domains = config.getInitParameter("domains");
        System.out.println(domains);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getServletPath().equals("/login")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String source = req.getParameter("source");

            if (username.equals(password)) {
                resp.sendRedirect(source + "/home?ticket=" + username +
                        "&domains=" + domains.replace(source, "").replace(",", "") );
            } else {
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
            }
        } else if (req.getServletPath().equals("/ssoLogin")) {
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
