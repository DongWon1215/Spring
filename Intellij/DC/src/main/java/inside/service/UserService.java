package inside.service;

import inside.domain.UserDTO;
import inside.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Service
@Log4j2
public class UserService {
    @Autowired(required = false)
    UserMapper userMapper;

    public UserDTO getUserByIdPassword(String userId, String userPassword)
    {
        UserDTO UserDTO = null;

        UserDTO = userMapper.selectByIdPw(userId, userPassword);

        return UserDTO;
    }

    public boolean insertUser(String userid, String userPassword, String userNickName, MultipartFile userPhoto, HttpServletRequest request)
    {
        String newFilePath = null;

        if(userPhoto != null && !userPhoto.isEmpty() && userPhoto.getSize() > 0)
        {
            String dirURI = "/uploadfile/profile/";
            String dirRealURI = request.getSession().getServletContext().getRealPath(dirURI);

            newFilePath = userNickName + userPhoto.getOriginalFilename();

            try {
                userPhoto.transferTo(new File(dirRealURI,newFilePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(userMapper.insertUser(new UserDTO(userid,userPassword,userNickName,newFilePath)) != 0)
            return true;
        }

        if(userMapper.insertUser(new UserDTO(userid,userPassword,userNickName,null)) != 0)
            return true;

        return false;
    }
    public boolean updateUser(String id,String password, String nickname, MultipartFile photo, HttpServletRequest request)
    {
        String newFilePath = null;

        if(photo != null && !photo.isEmpty() && photo.getSize() > 0)
        {
            String dirURI = "/uploadfile/profile/";
            String dirRealURI = request.getSession().getServletContext().getRealPath(dirURI);

            newFilePath = nickname + photo.getOriginalFilename();

            try {
                photo.transferTo(new File(dirRealURI,newFilePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(userMapper.updateUser(id,password,nickname,newFilePath) != 0)
                return true;
        }
        if(userMapper.updateUser(id,password, nickname,null) != 0)
            return true;

        return false;
    }
    public boolean deleteUser(String id)
    {
        if(userMapper.deleteUser(id) != 0)
            return true;

        return false;
    }
}
