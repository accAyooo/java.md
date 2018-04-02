package com.study.jdbc.dao;

import com.study.jdbc.bean.User;
import com.study.jdbc.utils.DatabaseUtils;

import java.sql.*;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:14 2018/3/31
 */
public class UserDao {
    public User login(String username, String password) {
        PreparedStatement st = null;
        ResultSet rs = null;
        User user = null;

        Connection connection = DatabaseUtils.getConnection();
        String sql = "SELECT * FROM user WHERE username=? AND password=?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setAttr(rs.getString("addr"));
                user.setPhoneNum(rs.getString("phone_num"));
                user.setRealName(rs.getString("real_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.release(rs, st, connection);
        }

        return user;
    }
}
