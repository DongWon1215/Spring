package todoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoList.domain.User;
import todoList.domain.UserRegRequest;
import todoList.mapper.UserMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Service
public class UserRegService {
    //사용자 요청 데이터를 받고 파일 업로드 처리. DAO INTERT 요청

    @Autowired
    private UserMapper userMapper;

    public int UserReg(UserRegRequest regRequest, HttpServletRequest request) throws Exception {
        String newFileName = null;

        if(regRequest.getUserPhoto()!=null&&!regRequest.getUserPhoto().isEmpty() && regRequest.getUserPhoto().getSize() >0)
        {
            String driURI = "/uploadfile/user";

            newFileName = System.currentTimeMillis() + regRequest.getUserPhoto().getOriginalFilename();

            String dirRealPath = request.getSession().getServletContext().getRealPath(driURI);
            try {
                regRequest.getUserPhoto().transferTo(new File(dirRealPath, newFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        User user = regRequest.toUser();
        if(newFileName != null)
            user.setUserPhoto(newFileName);

        return userMapper.insertUser(user);
    }
}
