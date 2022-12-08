package com.app.board.service;

import com.app.board.Domain.BoardDTO;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardViewService {

    @Autowired
    private BoardMapper boardMapper;

    public BoardDTO getBoardDTO(int bno)
    {
        return boardMapper.selectByBno(bno);
    }
}
