package com.dc.controller.Post;

import com.dc.domain.PostListRequest;
import com.dc.domain.PostListSimplyRequest;
import com.dc.entity.Post;
import com.dc.service.PostListService;
import com.dc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postlist")
public class postListController {

    @Autowired
    private PostListService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostListRequest> viewPage(@RequestBody PostListSimplyRequest simplyRequest)
    {
        int currentPage = simplyRequest.getCurNum();
        int countPerPage = simplyRequest.getCountPerPage();
        return new ResponseEntity<>(service.getPostList(currentPage,countPerPage), HttpStatus.OK);
    }
}
