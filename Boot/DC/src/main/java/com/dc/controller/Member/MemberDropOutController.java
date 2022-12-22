package com.dc.controller.Member;

import com.dc.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.hibernate.ObjectDeletedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dropout")
@Log4j2
public class MemberDropOutController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public String gettext()
    {
        return "main";
    }


    @DeleteMapping("/{idx}")
    public String dropout(@PathVariable("idx") Integer idx)
    {
        try {
            memberService.withdrawalMemberByAdmin(idx);
        }
        catch (ObjectDeletedException e)
        {
            return "2";
        }
        return "1";
    }
}
