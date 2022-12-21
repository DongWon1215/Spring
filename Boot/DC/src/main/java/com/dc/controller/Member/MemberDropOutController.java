package com.dc.controller.Member;

import com.dc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dropout")
public class MemberDropOutController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public String dropout()
    {
        return "redirect:/auth/dropout";
    }

    @PostMapping
    public void dropout(@RequestParam("memberNum") Integer memberIndex)
    {
        memberService.withdrawalMemberByAdmin(memberIndex);
    }
}
