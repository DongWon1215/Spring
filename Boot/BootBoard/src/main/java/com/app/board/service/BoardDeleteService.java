package com.app.board.service;

import com.app.board.Domain.BoardDTO;
import com.app.board.Domain.BoardListPage;
import com.app.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.List;

@Service
@Log4j2
public class BoardDeleteService {
    @Autowired
    private BoardMapper boardMapper;

    public int deleteByBno(int bno)
    {
        BoardDTO dto = boardMapper.selectByBno(bno);

        boardMapper.deleteByBno(bno);

        if(dto.getPhoto() != null)
        {
            File delFile = new File(new File("").getAbsolutePath(),"photo" + File.separator + dto.getPhoto());

            if(delFile.exists())
                delFile.delete();
        }

        // 삭제 결과

        return 1;
    }
}