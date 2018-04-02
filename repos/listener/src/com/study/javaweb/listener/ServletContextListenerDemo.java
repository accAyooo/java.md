package com.study.javaweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:25 2018/3/12
 */
public class ServletContextListenerDemo implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String projectName = servletContextEvent.getServletContext().getInitParameter("project-name");
        String projectVersion = servletContextEvent.getServletContext().getInitParameter("project-version");

        servletContextEvent.getServletContext().setAttribute("projectName", projectName);
        servletContextEvent.getServletContext().setAttribute("projectVersion", projectVersion);

        int linkNumber = 0;
        servletContextEvent.getServletContext().setAttribute("linkNumber", linkNumber);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        String projectName = (String) servletContextEvent.getServletContext().getAttribute("projectName");
        String projectVersion = (String) servletContextEvent.getServletContext().getAttribute("projectVersion");

        System.out.println("projectName : " + projectName);
        System.out.println("projectVersion : " + projectVersion);
    }
}
