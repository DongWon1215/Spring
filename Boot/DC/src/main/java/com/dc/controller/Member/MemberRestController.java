package com.dc.controller.Member;

import com.dc.entity.Member;
import com.dc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("member")
public class MemberRestController {
    @Autowired
    private MemberService service;

    @GetMapping
    public ResponseEntity<List<Member>> getUserMember()
    {
        return new ResponseEntity<>(service.getMemberList(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> registMember(@RequestBody Member member)
    {
        return new ResponseEntity<>(service.registerMember(member), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Integer> updateMemberInfo(@RequestBody Member member)
    {
        return new ResponseEntity<>(service.updateMember(member),HttpStatus.OK);
    }

    @DeleteMapping
    public String withdrawalMember(@RequestParam("id")String id,@RequestParam("password")String password)
    {
        service.withdrawalMemberByIdAndPassword(id, password);
        return "redirect:/";
    }

}
