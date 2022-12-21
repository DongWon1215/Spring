package com.dc.controller.Post;

import com.dc.entity.Post;
import com.dc.service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/post")
@Log4j2
public class PostRestController {

    @Autowired
    private PostService service;

    @GetMapping({"/read"})
    public void viewPage(@RequestParam("index") Integer postIndex, @RequestParam(value = "page",defaultValue = "1") int pageNum, Model model)
    {
        model.addAttribute("curPage",pageNum);
        model.addAttribute("postIndex",service.findPostByIdx(postIndex).getIdx());
        model.addAttribute("post",service.findPostByIdx(postIndex));
    }

    @PostMapping
    public ResponseEntity<List<Post>> writePost(@RequestBody Post post, @RequestParam("img")MultipartFile img)
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
                post.setImg(newFileName);
            http = HttpStatus.OK;
        }

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

        return new ResponseEntity<>(service.getPostList(post.getCategory()), HttpStatus.OK);
    }

    @PutMapping({"/{index}"})
    public ResponseEntity<Integer> updatePost(@RequestBody Post post, @RequestParam("img")MultipartFile img, @PathVariable("index") Integer postIndex)
    {File saveDir = null;
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
