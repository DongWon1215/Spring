package todoList.service;

import org.springframework.stereotype.Service;
import todoList.Util.ConnectionProvider;
import todoList.dao.UserDAO;
import todoList.domain.User;
import todoList.domain.UserRegRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

@Service
public class UserRegService {
    //사용자 요청 데이터를 받고 파일 업로드 처리. DAO INTERT 요청

    UserDAO userdao = new UserDAO();
    public int UserReg(UserRegRequest regRequest, HttpServletRequest request) throws Exception {
        String newFileName = null;

        if(regRequest.getUserPhoto()!=null&&!regRequest.getUserPhoto().isEmpty() && regRequest.getUserPhoto().getSize() >0)
        {
            String driURI = "/uploadfile/user";

            newFileName = System.currentTimeMillis() + regRequest.getUserPhoto().getOriginalFilename();

            String dirRealPath = request.getSession().getServletContext().getRealPath(driURI);
            try {
                regRequest.getUserPhoto().transferTo(new File(dirRealPath, regRequest.getUserPhoto().getOriginalFilename()));
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }

        User user = regRequest.toUser();
        if(newFileName != null)
            user.setUserPhoto(newFileName);

        Connection conn = ConnectionProvider.getInstance().getConnection();

        return userdao.insertUser(conn,user);
    }
}
