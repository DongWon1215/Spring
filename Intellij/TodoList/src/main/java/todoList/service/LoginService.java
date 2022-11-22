package todoList.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.Util.ConnectionProvider;
import todoList.dao.UserDAO;
import todoList.domain.User;

import java.sql.Connection;

@Service
public class LoginService {

    public static User login(String userId, String userPw) throws Exception {
        UserDAO userdao = new UserDAO();
        Connection conn = ConnectionProvider.getInstance().getConnection();
        return userdao.selectUserByNamePassword(conn, userId, userPw);
    }
}
