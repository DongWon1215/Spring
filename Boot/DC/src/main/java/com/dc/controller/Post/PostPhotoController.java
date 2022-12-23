package com.dc.controller.Post;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@Log4j2
public class PostPhotoController {

    @GetMapping(value = "/upload/post/photo/{filename}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> viewImg(@PathVariable("filename") String fileName) throws IOException
    {
        byte[] imgByteArray = null;
        HttpStatus state = HttpStatus.NOT_FOUND;
        File saveFile = new File(new File("").getAbsolutePath(),"resource\\meme\\"+fileName);
        if(saveFile.exists())
        {
            @Cleanup InputStream inputStream = new FileInputStream(saveFile);
            imgByteArray = inputStream.readAllBytes();
            state = HttpStatus.OK;
        }

        return new ResponseEntity<byte[]>(imgByteArray,state);
    }


}
