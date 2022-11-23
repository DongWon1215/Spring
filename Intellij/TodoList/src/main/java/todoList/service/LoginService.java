package todoList.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import todoList.Util.ConnectionProvider;
import todoList.dao.UserDAO;
import todoList.domain.User;

import java.sql.Connection;

@Service
@Log4j2
public class LoginService {

    public static User login(String userId, String userPw) throws Exception {
        UserDAO userdao = new UserDAO();
        Connection conn = ConnectionProvider.getInstance().getConnection();
        return userdao.selectUserByNamePassword(conn, userId, userPw);
    }
}
