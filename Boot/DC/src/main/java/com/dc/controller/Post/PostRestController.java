package com.dc.controller.Post;

import com.dc.domain.PostWriteRequest;
import com.dc.entity.Post;
import com.dc.service.PostService;
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
@RequestMapping("/post")
@Log4j2
public class PostRestController {

    @Autowired
    private PostService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Post>> viewPage()
    {
        return new ResponseEntity<>(service.getPostList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Post>> writePost(PostWriteRequest writeRequest)
    {
        MultipartFile img = writeRequest.getImg();

        log.info("request = " + writeRequest);

        Post post = writeRequest.toPost();

        File saveDir = null;
        String newFileName = null;

        HttpStatus http = HttpStatus.BAD_REQUEST;

        if(img != null && img.getSize() > 0 && !img.isEmpty())
        {
            String absolutePath = new File("").getAbsolutePath();
            String path = "resource\\meme";

            saveDir =new File(absolutePath,path);

            log.info(saveDir);

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
                post.setImg(newFileName);


            http = HttpStatus.OK;
        }

        post.setWriteDate(LocalDate.now());

        if(service.insertPost(post) < 1)
        {
            File delFile = new File(saveDir,newFileName);
            http = HttpStatus.BAD_REQUEST;
            if(delFile.exists())
            {
                delFile.delete();
                return new ResponseEntity<>(null, http);
            }
        }

        return new ResponseEntity<>(service.getPostList(), HttpStatus.OK);
    }

    @PutMapping({"/{index}"})
    public ResponseEntity<Integer> updatePost(@RequestBody Post post, @RequestParam("img")MultipartFile img, @PathVariable("index") Integer postIndex)
    {File saveDir = null;
        String newFileName = null;

        HttpStatus http = HttpStatus.BAD_REQUEST;

        if(img != null && img.getSize() > 0 && !img.isEmpty())
        {
            String absolutePath = new File("").getAbsolutePath();
            String path = "resource\\meme";

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
                post.setImg(newFileName);
            http = HttpStatus.OK;
        }
        post.setIdx(postIndex);
        Integer result = service.updatePost(post);
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

    @DeleteMapping({"/{index}"})
    public ResponseEntity<Integer> deletePost(@RequestBody Post post,@PathVariable("index") Integer postIndex)
    {
        if(service.findPostByIdPw(post.getWriter(),post.getPassword()) != null)
            return new ResponseEntity<>(service.deletePost(postIndex),HttpStatus.OK);

        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
