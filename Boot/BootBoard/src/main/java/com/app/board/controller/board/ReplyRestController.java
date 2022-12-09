package com.app.board.controller.board;

import com.app.board.Domain.ReplyDTO;
import com.app.board.service.ReplyInsertService;
import com.app.board.service.ReplyListService;
import com.app.board.service.ReplyReadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reply")
@Log4j2
public class ReplyRestController {

    @Autowired
    private ReplyListService replyService;

    @Autowired
    private ReplyInsertService replyInsertService;

    @Autowired
    private ReplyReadService readService;

    //get /reply/{bno} =>list
    @GetMapping(value = "/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)                    //produces : 반환하는 타입 rufwjd
    public ResponseEntity<List<ReplyDTO>> selectList(@PathVariable("bno")int bno)
    {
        List<ReplyDTO> list = replyService.selectAll(bno);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //post/reply => reply       JSON 데이터를 받아서 DB에 insert
    @PostMapping
    public ResponseEntity<ReplyDTO> insertReply(@RequestBody ReplyDTO replyDTO)
    {
        log.info("before insert : " + replyDTO);
        // Service -> Mapper

        replyInsertService.insertReply(replyDTO);

        log.info("after insert : " + replyDTO);     // 기대값 : rno 값이 갱신된 데이터 값

        replyDTO.setReplydate(LocalDate.now().toString());

        return new ResponseEntity<>(readService.readReply(replyDTO.getRno()),HttpStatus.OK);
    }

    //put /reply/{rno} => reply

    //delate/reply/{rno} => 0 / 1, ok, fail


}
