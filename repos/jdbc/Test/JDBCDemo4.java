import org.junit.Test;
import java.sql.*;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:35 2018/3/29
 */
public class JDBCDemo4 {
    @Test
    public void testUtils() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM user WHERE uid=2");
            if (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, statement, resultSet);
        }
    }
}
