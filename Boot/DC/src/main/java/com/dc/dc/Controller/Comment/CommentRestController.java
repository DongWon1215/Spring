package com.dc.dc.Controller.Comment;

import com.dc.dc.Entity.Comment;
import com.dc.dc.Repository.CommentRepository;
import com.dc.dc.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @GetMapping({"/{postIndex}"})
    public ResponseEntity<List<Comment>>  getCommentList(@PathVariable("postIndex")Integer postIndex)
    {
        return new ResponseEntity<>(commentService.getCommentList(postIndex),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment)
    {
        commentService.insertComment(comment);
        return new ResponseEntity<>(commentService.getComment(comment.getIndex()), HttpStatus.OK);
    }

    @PutMapping({"/{index}"})
    public ResponseEntity updateComment(@RequestBody Comment comment)
    {
        return new ResponseEntity<>(commentService.updateComment(comment),HttpStatus.OK);
    }


    @DeleteMapping
    public void deleteComment(@RequestParam("id")String id, @RequestParam("password")String password)
    {
        commentService.delete(id, password);
    }
}
