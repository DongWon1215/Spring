package com.app.board.service;

import com.app.board.Domain.BoardArticleDTO;
import com.app.board.Domain.BoardDTO;
import com.app.board.Domain.BoardListPage;
import com.app.board.Repository.BoardRepository;
import com.app.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class BoardListService {
    @Autowired
    private BoardRepository boardRepository;

    public BoardListPage getPage(int pageNum)
    {
        List<BoardArticleDTO>list = boardMapper.selectList((pageNum - 1) * 10,10);

        log.info("==========================================" + list);

        int totalCount = boardMapper.totalCount();

        BoardListPage boardListPage = new BoardListPage(10,pageNum,list,totalCount);

        return boardListPage;
    }

    public List<BoardArticleDTO> getList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum)
    {
        int index = (pageNum - 1) * 10;
        int count = 10;
        return boardMapper.selectList(index, count);
    }

}
