package inside.domain;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Valid
@ToString
public class UserDTO {

    @NotBlank
    private String userId;

    @NotBlank
    private String password;

    @NotBlank
    private String nickName;

    private String photo;

}
