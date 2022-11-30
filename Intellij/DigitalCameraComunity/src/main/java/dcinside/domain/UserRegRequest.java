package todoList.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Member;

@Log4j2
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class UserRegRequest {
    @NotEmpty
    private String userId;
    @NotEmpty
    private String userPw;
    @NotNull
    private String userName;

    private MultipartFile userPhoto;

    public User toUser() {
        return User.builder().userId(this.userId).userPw(this.userPw).userName(this.userName).build();
    }
}
