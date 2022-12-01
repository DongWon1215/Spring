package inside.mapper;

import inside.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserDTO selectByIdPw (String userid, String userPassword);

    int insertUser(UserDTO userDTO);
    int updateUser(String userId, String userPassword, String userNickName,String userPhoto);
    int deleteUser(String userId);
}
