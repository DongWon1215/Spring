package com.dc.controller.Comment;

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
public class CommentPhotoController {

    @GetMapping(value = "/upload/comment/photo/{filename}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> viewImg(@PathVariable("fileName") String fileName) throws IOException
    {
        byte[] imgByteArray = null;
        HttpStatus state = HttpStatus.NOT_FOUND;

        File saveFile = new File(new File("").getAbsolutePath(),"resource\\dccon\\"+fileName);

        if(saveFile.exists())
        {
            InputStream inputStream = new FileInputStream(saveFile);
            imgByteArray = inputStream.readAllBytes();
            inputStream.close();
            state = HttpStatus.OK;
        }

        return new ResponseEntity<byte[]>(imgByteArray,state);
    }


}
