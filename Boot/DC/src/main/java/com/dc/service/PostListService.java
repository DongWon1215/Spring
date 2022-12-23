package com.dc.service;

import com.dc.domain.PostListRequest;
import com.dc.entity.Post;
import com.dc.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PostListService {
    @Autowired
    private PostRepository repository;

    public PostListRequest getPostList(@PathVariable(required = false) Integer pageNum, Integer pageSize)
    {
        if(pageNum == null)
            pageNum = 1;

        if(pageSize == null)
            pageSize = 30;

        Page<Post> postPage = repository.findAll(PageRequest.of(pageNum - 1, pageSize, Sort.by("idx").descending()));

        List<Post> list = postPage.getContent();

        return new PostListRequest(pageSize,pageNum,list,(int)postPage.getTotalElements());
    }


}
