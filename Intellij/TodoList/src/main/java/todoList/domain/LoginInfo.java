package todoList.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LoginInfo {
    private String userId;
    private String userName;
    private String userPhoto;

}
