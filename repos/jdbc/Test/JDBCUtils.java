
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:19 2018/3/29
 */
public class JDBCUtils {
    public static final String driverClass;
    public static final String jdbcUrl;
    public static final String username;
    public static final String password;

    static {
        // 创建接受jdbc文件的类
        Properties properties = new Properties();
        // 访问位置读取inputstream对象
        InputStream inputStream = JDBCUtils.class.getClassLoader()
                .getResourceAsStream("jdbc.properties");
        try {
            // load is对象
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driverClass = properties.getProperty("driverClass");
        jdbcUrl = properties.getProperty("jdbcUrl");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    public static void loadDriver() throws ClassNotFoundException {
        Class.forName(driverClass);
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        loadDriver();
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        return connection;
    }

    public static void release(Connection connection, Statement statement) {
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

    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
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
