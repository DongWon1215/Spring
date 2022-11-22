package todoList.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.multipart.MultipartFile;

@Log4j2
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String userId;
    private String userPw;
    private String userName;
    private String userPhoto;

    public LoginInfo toLoginInfo()
    {
        return LoginInfo.builder().userId(this.userId).userName(this.userName).userPhoto(this.userPhoto).build();
    }
}