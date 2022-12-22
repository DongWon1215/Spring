package com.dc.domain;

import com.dc.entity.Post;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostListRequest {

    private int curNum;
    private int countPerPage;
    private int startNum;
    private int endNum;
    private int totalCount;

    private boolean isPrev;
    private boolean isNext;

    private List<Post> list;

    private void calListInfo()
    {

    }
}
