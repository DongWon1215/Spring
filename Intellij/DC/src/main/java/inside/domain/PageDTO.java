package inside.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PageDTO {

    private int curPage;
    private int totalPage;
    private int totalPost;
    private List<PostDTO> list;
}
