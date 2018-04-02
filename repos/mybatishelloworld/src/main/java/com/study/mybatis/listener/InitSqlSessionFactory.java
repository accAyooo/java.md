package com.study.mybatis.listener;

import com.study.mybatis.utils.SqlSessionFactoryUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:16 2018/4/2
 */

@WebListener
public class InitSqlSessionFactory implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        SqlSessionFactoryUtils.initSqlSessionFactory();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        SqlSessionFactoryUtils.close();
    }
}
