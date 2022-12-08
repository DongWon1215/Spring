package com.app.board.service;

import com.app.board.Domain.BoardWriteRequest;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class BoardWriteService {

    @Autowired
    private BoardMapper boardMapper;

    public boolean writePage(BoardWriteRequest boardWriteRequest)
    {
        MultipartFile file = boardWriteRequest.getFormFile();

        if(file != null && !file.isEmpty() && file.getSize() > 0)
        {
            String absolutePath = new File("").getAbsolutePath();

            String path = "photo";

            // 새로운 저장 경로 생성
            File savedir = new File(absolutePath, path);

            // 폴더가 존재하지 않으면 생성
            if(!savedir.exists())
                savedir.mkdir();


            // 새로운 저장 파일의 경로
            File newfile = new File(savedir,file.getOriginalFilename());

            // 파일 저장
            try {
                file.transferTo(newfile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
            
//        if(boardMapper. != 0)
//            return true;

        return false;
    }
}
