package com.app.board.service;

import com.app.board.Domain.BoardDTO;
import com.app.board.Domain.BoardEditRequest;
import com.app.board.Repository.BoardRepository;
import com.app.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@Service
@Log4j2
public class BoardEditService {
    @Autowired
    private BoardRepository boardRepository;

    public int edit(BoardEditRequest boardEditRequest)
    {
        MultipartFile file = boardEditRequest.getFormFile();
        File savedir = null;
        String newFileName = null;

        if(file != null && !file.isEmpty())
        {
            // 새로운 파일 저장
            // 이전 파일이 존재한다면 이전 파일 삭제
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

        BoardDTO boardDTO = boardEditRequest.toBoardDTO();

        if (newFileName != null)
            boardDTO.setPhoto(newFileName);

        try
        {
            //db update
            boardRepository.save(boardDTO);
            if (newFileName != null && boardEditRequest.getOldFile() != null && !boardEditRequest.getOldFile().trim().isEmpty())
            {
                File delOldFile = new File(new File("").getAbsolutePath(), "photo" + File.separator + boardEditRequest.getOldFile());
                if (delOldFile.exists())
                    delOldFile.delete();
            }
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
        // 새로운 파일 O , 이번파일 존재 O => 기존 파일 삭제 후 새로운 파일 저장
        return 1;
    }

}
