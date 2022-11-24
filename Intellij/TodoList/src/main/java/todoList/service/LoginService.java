package todoList.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoList.domain.User;
import todoList.mapper.UserMapper;

@Service
@Log4j2
public class LoginService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public User login(String userId, String userPw) throws Exception {
        return userMapper.selectUserByNamePassword(userId, userPw);
    }

    public int withdrawal(String userId) throws Exception {
        return userMapper.deleteUser(userId);
    }

}