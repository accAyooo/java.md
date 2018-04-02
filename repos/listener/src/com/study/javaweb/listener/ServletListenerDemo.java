package com.study.javaweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:10 2018/3/12
 */

public class ServletListenerDemo implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("listener has initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("listener has destroyed");
    }
}
