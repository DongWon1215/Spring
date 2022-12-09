package com.app.board;

import com.app.board.Domain.BoardDTO;
import com.app.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class mapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void mapperTest()
    {
        List<BoardDTO> list1 = boardMapper.selectAll();
        log.info("board data =" + list1);

        // 1페이지 : 10개의 게시물
//        List<BoardDTO> list2 = boardMapper.selectList(0,10);
//        log.info("board data =" + list2);
    }
}
