package todoList.domain;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Validated
public class LoginInfo {

    @NonNull
    private String userId;

    @NonNull
    private String userName;

    
    private String userPhoto;

}
