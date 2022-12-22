package com.dc.service;

import com.dc.entity.Post;
import com.dc.repository.CommentRepository;
import com.dc.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    @Autowired
    private CommentRepository commentRepository;

    public int insertPost(Post post)
    {
        return repository.save(post) != null ? 1 : 0;
    }

    public int updatePost(Post post)
    {
        return repository.save(post) != null ? 1 : 0;
    }

    public List<Post> getPostList()
    {
        return repository.findAll();
    }

    public Post findPostByIdx(Integer index)
    {
        return repository.findById(index).get();
    }

    public Post findPostByIdPw(String id, String password)
    {
        return repository.findByWriterAndPassword(id,password);
    }

    public int deletePost(Integer index) {
        try
        {
            commentRepository.deleteByPostIndex(index);
            repository.deleteById(index);
        }
        catch (Exception e)
        {
            return 0;
        }
        return 1;
    }

    public void deletePostByAdmin(Integer index)
    {
        commentRepository.deleteByPostIndex(index);
        repository.deleteById(index);
    }
}
