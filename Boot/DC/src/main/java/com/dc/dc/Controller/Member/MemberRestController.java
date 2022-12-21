package com.dc.dc.Controller.Member;

import com.dc.dc.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("member")
public class MemberRestController {
    @Autowired
    private MemberService service;

    @GetMapping
    public void getUserMember()
    {
        service.getMemberList();
    }

    @PostMapping
    public String temp()
    {
        return null;
    }

    @DeleteMapping
    public String withdrawalMember(@RequestParam("id")String id,@RequestParam("password")String password)
    {
        service.withdrawalMemberByIdAndPassword(id, password);
        return "redirect:/";
    }

}
