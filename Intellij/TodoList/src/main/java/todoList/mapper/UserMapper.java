package todoList.mapper;

import org.apache.ibatis.annotations.Mapper;
import todoList.domain.User;

@Mapper
public interface UserMapper {

    int insertUser(User user);
    int deleteUser(String userId);
    int updateUser(String serial);
    User selectUserByNamePassword(String userId, String userPw);
}
