package com.study.jdbc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 上午12:21 2018/4/1
 */
public class CharsetEncodingFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        filterChain .doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
