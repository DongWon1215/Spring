package com.app.board.controller.board;

import com.app.board.service.BoardListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class BoardListController {
    @Autowired
    private BoardListService boardListService;

    @GetMapping("/board/list")
    public void getList(@RequestParam(value="p", defaultValue = "1") int pageNum, Model model)
    {
//        log.info("페이지 값 : " + pageNum);
//        log.info("데이터값 : " + boardListService.getPage(pageNum));

        model.addAttribute("boardList", boardListService.getList(pageNum));
        model.addAttribute("listPage",boardListService.getPage(pageNum));
    }
}
