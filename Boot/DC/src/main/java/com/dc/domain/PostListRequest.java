package com.dc.domain;

import com.dc.entity.Post;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
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
        this.endNum = (int)(Math.ceil((this.curNum * 1.0)/this.countPerPage)) * this.countPerPage;
        this.startNum = this.endNum - this.countPerPage + 1;

        int realEnd = (int)(Math.ceil((this.curNum * 1.0)/this.countPerPage));

        this.endNum = realEnd < endNum ? realEnd : endNum;

        this.isPrev =this.startNum > 1;
        this.isNext = this.endNum < realEnd;
    }

    public PostListRequest(int countPerPage,int curNum,List<Post> list ,int totalCount)
    {
        this.countPerPage = countPerPage;
        this.curNum = curNum;
        this.totalCount = totalCount;
        this.list = list;

        calListInfo();
    }
}
