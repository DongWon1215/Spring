package com.dc.dc.Controller.Post;

import com.dc.dc.Entity.Post;
import com.dc.dc.Service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
@Log4j2
public class PostRestController {

    @Autowired
    private PostService service;

    @GetMapping({"/read"})
    public void viewPage(@RequestParam("index") Integer postIndex, @RequestParam("page") int pageNum, Model model)
    {
        model.addAttribute("curPage",pageNum);
        model.addAttribute("postIndex",service.findPostByIdx(postIndex).getIndex());
    }

    @PostMapping
    public ResponseEntity writePost(@RequestBody Post post)
    {
        service.insertPost(post);

        return new ResponseEntity<>(service.getPostList(post.getCategory()), HttpStatus.OK);
    }

    @PutMapping({"/{index}"})
    public ResponseEntity updatePost(@RequestBody Post post, @PathVariable("index") Integer postIndex)
    {
        post.setIndex(postIndex);

        return new ResponseEntity<>(service.updatePost(post),HttpStatus.OK);
    }

    @DeleteMapping({"/{index}"})
    public ResponseEntity deletePost(@RequestBody Post post,@PathVariable("index") Integer postIndex)
    {
        if(service.findPostByIdPw(post.getWriter(),post.getPassword()) != null)
            return new ResponseEntity<>(service.deletePost(postIndex),HttpStatus.OK);

        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
