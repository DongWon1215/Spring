package todoList.domain;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Valid
public class LoginInfo {

    @NotEmpty
    private String userId;

    @NotNull
    private String userName;

    @NotNull
    private String userPhoto;

}
