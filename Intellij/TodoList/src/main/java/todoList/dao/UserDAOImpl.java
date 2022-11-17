package todoList.dao;

import todoList.domain.User;

import java.sql.Connection;

public class UserDAOImpl implements UserDAO {
    @Override
    public int insertUser(Connection conn, User user) {
        String sql = "insert into ";

        return 0;
    }

    @Override
    public int deleteUser(Connection conn, User user) {
        return 0;
    }

    @Override
    public int updateUser(Connection conn, String serial) {
        return 0;
    }

    @Override
    public User selectUserByName(Connection conn, String userId) {
        return null;
    }
}
