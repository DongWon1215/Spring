package com.app.board.service;

import com.app.board.Domain.BoardDTO;
import com.app.board.Repository.BoardRepository;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardViewService {

    @Autowired
    private BoardRepository boardRepository;

    public BoardDTO getBoardDTO(Integer bno)
    {
        return boardRepository.findById(bno).get();
    }
}
