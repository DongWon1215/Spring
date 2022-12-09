package com.app.board.service;

import com.app.board.Domain.ReplyDTO;
import com.app.board.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyReadService {

    @Autowired
    private ReplyMapper replyMapper;

    public ReplyDTO readReply(int rno)
    {
        return replyMapper.selectByRno(rno);
    }

}
