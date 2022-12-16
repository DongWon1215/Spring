package com.app.board.service;

import com.app.board.Domain.ReplyDTO;
import com.app.board.Repository.ReplyRepository;
import com.app.board.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyReadService {

    @Autowired
    private ReplyRepository replyRepository;

    public ReplyDTO readReply(Integer rno)
    {
        return replyRepository.findById(rno).get();
    }

}
