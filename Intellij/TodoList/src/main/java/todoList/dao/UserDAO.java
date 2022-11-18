package todoList.dao;

import todoList.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public int insertUser(Connection conn, User user) throws SQLException
    {


        String sql = "insert into  values(?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,user.getIndex());
        pstmt.setString(2,user.getUserId());
        pstmt.setString(3,user.getUserPw());
        pstmt.setString(4,user.getSerialNum());

        return pstmt.executeUpdate();
    }

    public int deleteUser(Connection conn, User user) throws SQLException
    {
        String sql = "delete from where serialNum = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,user.getSerialNum());

        return pstmt.executeUpdate();
    }

    public int updateUser(Connection conn, String serial) throws SQLException
    {
        String sql = "delete from where serialNum = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,serial);

        return pstmt.executeUpdate();

    }

    public User selectUserByName(Connection conn, String userId) throws SQLException
    {
        User user = null;
        String sql = "select * from where userId = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userId);

        ResultSet rs = pstmt.executeQuery();

        if(rs.next())
        {
            user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
        }

        return user;
    }
}
