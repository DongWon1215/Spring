package todoList.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.domain.User;

@Mapper
public interface UserMapper {

    int insertUser(User user);
    int deleteUser(String userId);
    int updateUser(String userPw, String userName, String userPhoto, String userId);
    User selectUserByNamePassword(
            @Param("id") String userId, // param1
            @Param("pw") String userPw   // param2
    );
}
