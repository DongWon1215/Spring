package todoList.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Log4j2
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class User {
    @NotEmpty
    private String userId;
    @NotEmpty
    private String userPw;
    @NotNull
    private String userName;
    private String userPhoto;

    public LoginInfo toLoginInfo()
    {
        return LoginInfo.builder().userId(this.userId).userName(this.userName).userPhoto(this.userPhoto).build();
    }
}