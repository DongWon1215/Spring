package com.app.board;

import com.app.board.Domain.BoardDTO;
import com.app.board.Domain.BoardEditRequest;
import com.app.board.Domain.BoardWriteRequest;
import com.app.board.Repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void saveTest()
    {
        //BoardWriteRequest -> Entity -> save()

        BoardWriteRequest writeRequest = BoardWriteRequest.builder().title("한화의").writer(0).content("감동님 사랑해").build();

        BoardDTO boardDTO = writeRequest.toBoardDTO();

        log.info("insert  전 : " + boardDTO);

        log.info("insert  후 : " + boardRepository.save(boardDTO));
    }

    @Test
    public void readTest()
    {
        log.info("");
    }

    @Test
    public void editTest()
    {
        BoardEditRequest editRequest = BoardEditRequest.builder().bno(107).title("12.16에 수정").content("했다고").build();

        BoardDTO boardDTO = editRequest.toBoardDTO();
        boardDTO.setUpdatedate(LocalDate.now());

        log.info("수정 전 데이터 >>>>>>> " + boardDTO );

        boardDTO = boardRepository.save(boardDTO);

        log.info("수정 후 데이터 >>>>>>> " + boardDTO );
    }


    @Test
    public void listTest()
    {
        // 페이징 -> 구간 select, 한 페이지에 n개씩 게시물이 출력
        Page<BoardDTO> page = boardRepository.findAll(PageRequest.of(0,10, Sort.by("bno").descending()));

        // 전체 페이지 개수
        long totalCnt = page.getTotalElements();

        // 게시물 리스트
        for(BoardDTO board : page.getContent())
        {
            log.info(board);
        }
    }
}
