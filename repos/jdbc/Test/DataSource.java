import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.*;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:59 2018/3/30
 */

// 连接池测试类
public class DataSource {
    @Test
    public void test1() {
        // 初始化
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 初始化连接池设置
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql:///jdbc_test");
            dataSource.setUser("root");
            dataSource.setPassword("");
            dataSource.setMaxPoolSize(20);


            connection = dataSource.getConnection();
            String sql = "select * from user WHERE uid=3";
            ps =  connection.prepareStatement(sql);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, ps, resultSet);
        }

    }

    @Test
    public void test2() {
        // 初始化
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {

            connection = dataSource.getConnection();
            String sql = "select * from user WHERE uid=3";
            ps =  connection.prepareStatement(sql);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, ps, resultSet);
        }

    }
}
