package inside.domain;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Valid
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDTO {

    @NotBlank
    private String writer;

    @NotBlank
    private String password;

    @NotNull
    private String content;

    @NotNull
    private long postindex;

    @NotNull
    private long index;
}
