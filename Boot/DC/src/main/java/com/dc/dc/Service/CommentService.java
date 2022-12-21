package com.dc.dc.Service;

import com.dc.dc.Entity.Comment;
import com.dc.dc.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void delete(String writer, String password)
    {
        repository.deleteByWriterAndPassword(writer, password);
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
