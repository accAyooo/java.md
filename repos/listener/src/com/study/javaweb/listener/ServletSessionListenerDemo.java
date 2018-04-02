package com.study.javaweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:36 2018/3/12
 */
public class ServletSessionListenerDemo implements HttpSessionListener,ServletContextListener {
    int linkNumber;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        linkNumber ++;
        System.out.println(linkNumber);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        linkNumber --;
        System.out.println(linkNumber);
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.linkNumber = 0;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(linkNumber);
    }
}
