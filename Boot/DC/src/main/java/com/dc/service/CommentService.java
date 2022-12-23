package com.dc.service;

import com.dc.entity.Comment;
import com.dc.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public int insertComment(Comment comment)
    {


        return repository.save(comment) != null ? 1 : 0;
    }

    public int updateComment(Comment comment)
    {
        return repository.save(comment) != null ? 1 :0;
    }

    public int delete(String writer, String password, int idx)
    {
        return repository.deleteByWriterAndPassword(writer, password, idx);
    }

    public List<Comment> getCommentList(Integer postIndex)
    {
        return repository.findByPostIndex(postIndex);
    }

    public Comment getComment(Integer index)
    {
        return repository.findById(index).get();
    }
}
