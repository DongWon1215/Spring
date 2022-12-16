package com.app.board.service;

import com.app.board.Domain.BoardArticleDTO;
import com.app.board.Domain.BoardDTO;
import com.app.board.Domain.BoardListPage;
import com.app.board.Repository.BoardRepository;
import com.app.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
//        List<BoardArticleDTO>list = boardRepository.selectList((pageNum - 1) * 10,10);
//
//        log.info("==========================================" + list);
//
//        int totalCount = boardRepository.countBy();

        Page<BoardDTO> page = boardRepository.findAll(PageRequest.of(pageNum - 1,10, Sort.by("bno").descending()));

        List<BoardDTO> list = page.getContent();

        int totalCount = (int)page.getTotalElements();

        BoardListPage boardListPage = new BoardListPage(10,pageNum,list,totalCount);

        return boardListPage;
    }

    public List<BoardDTO> getList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum)
    {
        int index = (pageNum - 1) * 10;
        int count = 10;
        return boardRepository.findAll(PageRequest.of(index, count)).getContent();
    }

}
