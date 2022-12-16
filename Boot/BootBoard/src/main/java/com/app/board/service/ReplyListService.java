package com.app.board.service;

import com.app.board.Domain.ReplyDTO;
import com.app.board.Repository.ReplyRepository;
import com.app.board.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyListService {

    @Autowired
    private ReplyRepository replyRepository;

    public List<ReplyDTO> selectAll(Integer bno)
    {
        return replyRepository.findByBno(bno);
    }
}
