package com.study.service;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午11:23 2018/3/11
 */
public class FilterServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器开启");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        if (httpServletRequest.getAttribute("LOGIN_USER") == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/views/login.jsp?message=密码错误");
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器关闭");
    }
}
