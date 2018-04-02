import org.junit.Test;

import java.sql.*;
/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:37 2018/3/30
 */
public class JDBCDemo5 {
    Connection connection = null;
    PreparedStatement ps = null;

    /**
     * 使用preparestatement修改数据
     *
     */
    @Test
    public void prepareTest() {
        try {
            connection = JDBCUtils.getConnection();
            String sql = "UPDATE user SET username=? WHERE uid=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, "shixiangyu");
            ps.setInt(2, 2);
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, ps);
        }
    }
    @Test
    public void insertTest() {
        try {
            connection = JDBCUtils.getConnection();
            String sql = "INSERT user VALUES(NULL, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, "xanxue");
            ps.setString(2, "273626");
            ps.setString(3, "xiaoax");

            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, ps);
        }
    }
}
