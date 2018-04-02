import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.sql.*;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:24 2018/3/28
 */

public class UnitTest {
    @Test
    public void demo1() {
        ResultSet result = null;
        Statement statement = null;
        Connection connection = null;

        try {
            //1.加载驱动
            DriverManager.registerDriver(new Driver());
            //2.获得连接
            connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/jdbc_test", "root", "");
            //3.创建statement执行语句的对象
            statement = connection.createStatement();
            //4.执行sql
            result = statement.executeQuery("SELECT * FROM user");
            //5.处理结果
            while(result.next()) {
                System.out.print("uid: " + result.getInt("uid"));
                System.out.print("username: " + result.getString("username"));
                System.out.print("password: " + result.getString("password"));
                System.out.print("name: " + result.getString("name"));
                System.out.println("---------------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
                result = null;
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                statement = null;
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                connection = null;
            }
        }
    }
}
