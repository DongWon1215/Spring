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

    //한 페이지에 보여줄 글 수
    private int postNum;

    //현재 페이지
    private int curPage;

    //전체 글 수
    private int totalPost;

    // 글 리스트
    private List<PostDTO> list;

    private int startPage;
    private int endPage;

    private boolean isPrevExist;
    private boolean isNextExist;

    private void calculatevariable()
    {
        endPage = (int)(Math.ceil((curPage * 1.0) / postNum)) * postNum;
        startPage = endPage - postNum + 1;

        int realEnd = (int)(Math.ceil((totalPost * 1.0) /curPage));

        endPage = realEnd < endPage ? realEnd : endPage;

        isPrevExist = startPage > 1;
        isNextExist = endPage < realEnd;
    }

    public PageDTO(int postNum,int curPage, int totalPost, List<PostDTO> list)
    {
        this.postNum = postNum;
        this.curPage = curPage;
        this.totalPost = totalPost;
        this.list = list;

        calculatevariable();
    }

}
