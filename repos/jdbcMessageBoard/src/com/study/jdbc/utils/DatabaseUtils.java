package com.study.jdbc.utils;

import java.sql.*;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午3:32 2018/3/31
 */
public final class DatabaseUtils {
    private static String url;
    private static String user;
    private static String password;

    static {
        url = "jdbc:mysql:///jdbc_test";
        user = "root";
        password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动类异常");
            e.printStackTrace();
        }
    }

    private DatabaseUtils() {

    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("创建与数据库的连接错误");
            e.printStackTrace();
        }
        return connection;
    }

    public static void release(Statement st, Connection c) {
        if (st != null) {
            try {
                st.close();
                st = null;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (c != null) {
                    try {
                        c.close();
                        c = null;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void release(ResultSet rs, Statement st, Connection c) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(st, c);
        }

    }
}
