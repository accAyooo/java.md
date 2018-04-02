package com.study.jdbc.dao;

import com.study.jdbc.bean.Message;
import com.study.jdbc.utils.DatabaseUtils;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午4:09 2018/3/31
 */
public class MessageDao {

    /**
     * 获取所有消息
     * @param page 当前页
     * @param pageSize 每页总数
     * @return
     */
    public List<Message> getMessages(int page, int pageSize) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Message> result = new ArrayList<>();

        Connection connection = DatabaseUtils.getConnection();
        try {
            String sql = "SELECT * FROM message ORDER BY create_time DESC LIMIT ?, ? ";
            st = connection.prepareStatement(sql);
            st.setInt(1, (page - 1) * pageSize);
            st.setInt(2, pageSize);
            rs = st.executeQuery();

            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getLong("id"));
                message.setContent(rs.getString("content"));
                message.setTitle(rs.getString("title"));
                message.setCreateTime(rs.getTimestamp("create_time"));
                message.setUserId(rs.getLong("user_id"));
                message.setUsername(rs.getString("username"));

                result.add(message);
            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.release(rs, st, connection);
        }

        return null;
    }

    /**
     * 所有留言数量
     * @return
     */

    public int messageCount() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection connection = DatabaseUtils.getConnection();
        String sql = "SELECT COUNT(*) AS total FROM message";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.release(rs, ps, connection);
        }

        return 0;
    }

    public int addMessage(long id, String username, String title, String content) {
        PreparedStatement ps = null;
        int result = 0;
        Connection connection = DatabaseUtils.getConnection();
        String sql = "INSERT message VALUES(NULL, ?, ?, ?, ?, now()) ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.setString(2, username);
            ps.setString(3, title);
            ps.setString(4, content);

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.release(ps, connection);
        }

        return result;
    }
}
