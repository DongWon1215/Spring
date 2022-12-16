package com.app.board.service;

import com.app.board.Domain.BoardDTO;
import com.app.board.Domain.BoardWriteRequest;
import com.app.board.Repository.BoardRepository;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@Service
public class BoardWriteService {

    @Autowired
    private BoardRepository boardRepository;

    public boolean writePage(BoardWriteRequest boardWriteRequest)
    {
        MultipartFile file = boardWriteRequest.getFormFile();
        File savedir = null;
        String newFileName = null;

        boolean result = false;

        if(file != null && !file.isEmpty() && file.getSize() > 0)
        {
            String absolutePath = new File("").getAbsolutePath();

            String path = "photo";

            // 새로운 저장 경로 생성
            savedir = new File(absolutePath, path);

            // 폴더가 존재하지 않으면 생성
            if(!savedir.exists())
                savedir.mkdir();

            String uuid = UUID.randomUUID().toString();
            newFileName = uuid + file.getOriginalFilename();

            // 새로운 저장 파일의 경로
            File newfile = new File(savedir,newFileName);

            // 파일 저장
            try {
                file.transferTo(newfile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BoardDTO boardDTO = boardWriteRequest.toBoardDTO();

        if (newFileName != null)
            boardDTO.setPhoto(newFileName);

        try
        {
            result = boardRepository.save(boardDTO) != null ? true : false;
        }

        catch (Exception e)
        {
            if (newFileName != null)
            {
                File delFile = new File(savedir, newFileName);
                if (delFile.exists())
                    delFile.delete();
            }
        }
        return result;
    }
}
