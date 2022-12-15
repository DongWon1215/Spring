package com.app.board.service;

import com.app.board.Repository.ReplyRepository;
import com.app.board.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyDeleteSerivice {

    @Autowired
    private ReplyRepository replyRepository;


    public int deleteByRno(Integer rno)
    {
        return replyRepository.deleteById(rno);
    }

}
