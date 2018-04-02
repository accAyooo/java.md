import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午9:38 2018/3/29
 */
public class JDBCDemo2 {
    @Test
    public void test() {
        Connection connection = null;
        Statement statement = null;

        try {
            // 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 连接数据库
            connection = DriverManager.getConnection("jdbc:mysql:///jdbc_test", "root", "");
            // 创建statement对象
            statement = connection.createStatement();
            // 编写sql
            String sql = "INSERT user VALUES(null, 'shixiangyu', 'xiangyang12', 'ayooo')";
            int result = statement.executeUpdate(sql);

            if (result > 0) {
                System.out.println("执行成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                connection = null;
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                statement = null;
            }
        }

    }

    @Test
    public void updateSql() {
        Connection connection = null;
        Statement statement = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///jdbc_test", "root", "");
            statement = connection.createStatement();
            String sql = "UPDATE user SET username = 'shixy' WHERE uid=2";
            String delSql = "DELETE FROM user WHERE id=2";
            int result = statement.executeUpdate(sql);
            if (result > 0) {
                System.out.println("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                connection = null;
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                statement = null;
            }
        }
    }
}
