package com.dc.controller.Comment;

import com.dc.domain.CommentDeleteRequest;
import com.dc.domain.CommentWriteRequest;
import com.dc.entity.Comment;
import com.dc.service.CommentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/comment")
@Log4j2
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @GetMapping(value = {"/{postIndex}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comment>>  getCommentList(@PathVariable("postIndex")Integer postIndex)
    {
        return new ResponseEntity<>(commentService.getCommentList(postIndex),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> addComment(CommentWriteRequest writeRequest)
    {
        MultipartFile img = writeRequest.getImg();

        Comment comment = writeRequest.toComment();

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

        comment.setWriteDate(LocalDate.now());

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
    public ResponseEntity<Integer> updateComment(CommentWriteRequest writeRequest,@PathVariable("index") Integer index)
    {
        Comment comparison = commentService.getComment(index);

        log.info("원본 데이터 =>" + comparison);

        if(writeRequest.getWriter() != comparison.getWriter() || writeRequest.getPassword() != comparison.getPassword())
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        MultipartFile img = writeRequest.getImg();

        Comment comment = writeRequest.toComment();

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

        comment.setWriteDate(LocalDate.now());
        comment.setIdx(index);

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
    public ResponseEntity<Integer> deleteComment(@RequestBody CommentDeleteRequest request)
    {
        return new ResponseEntity<>(commentService.delete(request.getId(), request.getPassword(), request.getIdx()) < 1 ? 1 : 0,);
    }
}
