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
    private long postIndex;

    @NotNull
    private long postViews;

    @NotNull
    private String postTitle;

    @NotBlank
    private String postWriter;

    @NotBlank
    private String postPassword;

    @NotNull
    private String postContent;
}
