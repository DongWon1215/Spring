package todoList.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Member;

@Log4j2
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegRequest {
    private int index;
    private String userId;
    private String userPw;
    private String serialNum;
    private String userName;
    private MultipartFile userPhoto;

    public User toUser() {
        return User.builder().userId(this.userId).userPw(this.userPw).userName(this.userName).serialNum(this.userName).build();
    }
}
