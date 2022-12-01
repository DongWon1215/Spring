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
    private String commentWriter;

    @NotBlank
    private String commentPassword;

    @NotNull
    private String commentContent;

    @NotNull
    private long postIndex;

    @NotNull
    private long commentIndex;
}
