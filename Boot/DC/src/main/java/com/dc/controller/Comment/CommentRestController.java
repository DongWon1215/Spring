package com.dc.controller.Comment;

import com.dc.entity.Comment;
import com.dc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @GetMapping(value = {"/{postIndex}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comment>>  getCommentList(@PathVariable("postIndex")Integer postIndex)
    {
        return new ResponseEntity<>(commentService.getCommentList(postIndex),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment, @RequestParam("img")MultipartFile img)
    {
        File saveDir = null;
        String newFileName = null;

        HttpStatus http = HttpStatus.BAD_REQUEST;

        if(img != null && img.getSize() > 0 && !img.isEmpty())
        {
            String absolutePath = new File("").getAbsolutePath();
            String path = "resource\\dccon";

            saveDir =new File(absolutePath,path);

            if(!saveDir.exists())
            saveDir.mkdir();

            newFileName = img.getOriginalFilename();

            File newfile =new File(saveDir,newFileName);

            try
            {
                img.transferTo(newfile);
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }

            if(newFileName != null)
                comment.setImg(newFileName);
            http = HttpStatus.OK;
        }

        if(commentService.insertComment(comment) < 1)
        {
            File delFile = new File(saveDir,newFileName);
            http = HttpStatus.BAD_REQUEST;
            if(delFile.exists())
            {
                delFile.delete();
                return new ResponseEntity<>(null, http);
            }
        }

        return new ResponseEntity<>(commentService.getComment(comment.getIdx()), http);
    }

    @PutMapping({"/{index}"})
    public ResponseEntity<Integer> updateComment(@RequestBody Comment comment,@RequestParam("img")MultipartFile img)
    {
        File saveDir = null;
        String newFileName = null;

        HttpStatus http = HttpStatus.BAD_REQUEST;

        if(img != null && img.getSize() > 0 && !img.isEmpty())
        {
            String absolutePath = new File("").getAbsolutePath();
            String path = "dccon";

            saveDir =new File(absolutePath,path);

            if(!saveDir.exists())
                saveDir.mkdir();

            newFileName = path+img.getOriginalFilename();

            File newfile =new File(saveDir,newFileName);

            try
            {
                img.transferTo(newfile);
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }

            if(newFileName != null)
                comment.setImg(newFileName);
            http = HttpStatus.OK;
        }
        Integer result = commentService.updateComment(comment);
        if(result < 1)
        {
            File delFile = new File(saveDir,newFileName);
            http = HttpStatus.BAD_REQUEST;
            if(delFile.exists())
            {
                delFile.delete();
                return new ResponseEntity<>(null, http);
            }
        }

        return new ResponseEntity<>(result,HttpStatus.OK);
    }


    @DeleteMapping
    public void deleteComment(@RequestParam("id")String id, @RequestParam("password")String password)
    {
        commentService.delete(id, password);
    }
}
