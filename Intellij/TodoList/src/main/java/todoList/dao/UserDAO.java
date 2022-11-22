package todoList.dao;

import org.springframework.stereotype.Repository;
import todoList.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAO {
    public int insertUser(Connection conn, User user) throws SQLException
    {


        String sql = "insert into user (userId,userPw,userName,userPhoto) values(?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,user.getUserId());
        pstmt.setString(2,user.getUserPw());
        pstmt.setString(3,user.getUserName());
        pstmt.setString(4,user.getUserPhoto());

        return pstmt.executeUpdate();
    }

    public int deleteUser(Connection conn, User user) throws SQLException
    {
        String sql = "delete from user where userId = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,user.getUserId());

        return pstmt.executeUpdate();
    }

    public int updateUser(Connection conn, String serial) throws SQLException
    {
        String sql = "delete from user where serialNum = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,serial);

        return pstmt.executeUpdate();

    }

    public User selectUserByNamePassword(Connection conn, String userId, String userPw) throws SQLException
    {
        User user = null;
        String sql = "select * from user where userId = ? and userPw = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userId);
        pstmt.setString(2, userPw);

        ResultSet rs = pstmt.executeQuery();

        if(rs.next())
        {
            user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
        }

        return user;
    }
}
