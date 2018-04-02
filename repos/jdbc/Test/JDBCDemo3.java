import org.junit.Test;

import java.sql.*;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:00 2018/3/29
 */
public class JDBCDemo3 {
    @Test
    public void selectSqlTest() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql:///jdbc_test", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT * FROM user";
            resultSet = statement.executeQuery(sql);

            int resultCount = 0;
            while (resultSet.next()) {
                resultCount += 1;
                System.out.println(resultSet.getString("username"));
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
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                resultSet = null;
            }
        }
    }
}
