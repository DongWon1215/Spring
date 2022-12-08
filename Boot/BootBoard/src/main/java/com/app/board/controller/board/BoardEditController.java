package com.app.board.controller.board;

import com.app.board.Domain.BoardEditRequest;
import com.app.board.service.BoardEditService;
import com.app.board.service.BoardViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/edit")
public class BoardEditController {

    @Autowired
    private BoardEditService boardEditService;

    @Autowired
    private BoardViewService boardViewService;

    @GetMapping
    public void editPage(@RequestParam("bno")int bno, @RequestParam("p")int p, Model model)
    {
        model.addAttribute("board", boardViewService.getBoardDTO(bno));
        model.addAttribute("curPageNum",p);
    }

    @PostMapping
    public String editform(BoardEditRequest boardEditRequest, RedirectAttributes redirectAttributes)
    {


        redirectAttributes.addAttribute("bno", boardEditRequest.getBno());
        redirectAttributes.addAttribute("p", boardEditRequest.getCurPageNum());

        boardEditService.edit(boardEditRequest);

        return "redirect:/board/view";
    }

}
