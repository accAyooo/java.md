package com.study.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:01 2018/4/2
 */
public class SqlSessionFactoryUtils {
    // 设置配置文件名字
    private static String RESOURCE = "mybatis-config.xml";

    // 初始化一个sqlSessionFactory对象
    private static SqlSessionFactory sessionFactory;

    // 创建一个threadLocal类
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    // 初始化对象的方法
    public static void initSqlSessionFactory() {
        try {
            // 读取配置文件
            InputStream is = Resources.getResourceAsStream(RESOURCE);
            // 把配置文件传入到sqlSessionFactorybuilder()中创建sessionFactory对象
            sessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null) {
            sqlSession.close();
            threadLocal.set(null);
        }
    }
}
