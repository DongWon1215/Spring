package inside.domain;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
@Setter
@Builder
@Valid
public class PostDTO {

    @NotNull
    private long index;

    @NotNull
    private long views;

    private long commentnum;

    @NotNull
    private String title;

    @NotBlank
    private String writer;

    private String password;

    @NotNull
    private String content;

}
