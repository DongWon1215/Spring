package todoList.dao;

import todoList.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;

public interface UserDAO {
    int insertUser(Connection conn, User user);
    int deleteUser(Connection conn, User user);
    int updateUser(Connection conn, String serial);

    User selectUserByName(Connection conn, String userId);
}
