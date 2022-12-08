package com.app.board.Domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class BoardListPage {

    // 페이지당 출력할 계시물의 개수
    private int countPerPage;

    // 현재 페이지 번호
    private int currentPage;

    // 게시물의 리스트
    private List<BoardDTO> list;

    // 전체 게시물의 개수
    private int totalCount;

    // 페이징의 시작 번호
    private int pagingStart;

    // 페이징의 끝 번호
    private int pagingEnd;

    // 이전 버튼 출력 여부
    private boolean isPrevExist;

    // 다음 버튼 출력 여부
    private boolean isNextExist;

    private void calPageInfo()
    {
        // 끝번호 계산
        this.pagingEnd = (int)(Math.ceil((this.totalCount * 1.0) / 10)) * 10;

        // 시작 번호 계산
        this.pagingStart = this.pagingEnd - 9;

        // 전체 페이지의 끝 번호 계산
        int realEndNum = (int)(Math.ceil((this.totalCount * 1.0) / countPerPage));

        // 끝번호가 전체 페이지의 마지막 번호 보다 크면 끝번호를 변경
        this.pagingEnd = realEndNum < this.pagingEnd ? realEndNum : this.pagingEnd;

        //이전 번호가 존재하는지 유무 판단
        this.isPrevExist = this.pagingStart > 1;

        //다음 번호가 존재하는지 유무 판단
        this.isNextExist = this.pagingEnd < realEndNum;

    }

    public BoardListPage(int countPerPage, int currentPage, List<BoardDTO> list, int totalCount)
    {
        this.list = list;
        this.totalCount= totalCount;
        this.currentPage = currentPage;
        this.countPerPage = countPerPage;

        calPageInfo();
    }
}
