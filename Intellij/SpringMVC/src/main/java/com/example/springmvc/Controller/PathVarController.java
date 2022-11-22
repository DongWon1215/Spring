package com.example.springmvc.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class PathVarController {

    // http://localhost:8080/member/1
    // http://localhost:8080/member/13
    // http://localhost:8080/member/74

    @RequestMapping("/member/{type}/{idx}")
    public String getMemberInfo(@PathVariable("idx") String idx, @PathVariable("type") String type, Model model)
    {
        log.info(type);
        log.info(idx);

        model.addAttribute("type",type);
        model.addAttribute("idx",idx);

        return "info";
    }
}
