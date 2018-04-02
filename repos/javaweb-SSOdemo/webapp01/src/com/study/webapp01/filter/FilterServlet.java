package com.study.webapp01.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:09 2018/3/14
 */
public class FilterServlet implements Filter {
    private String serverDomain;
    private String appDomain;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        serverDomain = filterConfig.getInitParameter("serverDomain");
        appDomain = filterConfig.getInitParameter("appDomain");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ticket = null;
        Cookie[] cookies = ((HttpServletRequest)(servletRequest)).getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("USER_INFO_TICKET")) {
                    ticket = cookie.getName();
                    break;
                }
            }
        }
        if (ticket != null ) {
            // 需要进行用户的相关校验
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        ticket = servletRequest.getParameter("ticket");
        if (ticket!= null) {
            ((HttpServletResponse) servletResponse).addCookie(new Cookie("USER_INFO_TICKET", ticket));
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse)servletResponse).sendRedirect(serverDomain + "/ssoLogin?source=" + appDomain);
        }

    }

    @Override
    public void destroy() {

    }
}
