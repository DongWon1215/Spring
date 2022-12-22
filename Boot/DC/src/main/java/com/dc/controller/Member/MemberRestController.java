package com.dc.controller.Member;

import com.dc.entity.Member;
import com.dc.repository.MemberRepository;
import com.dc.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("member")
@Log4j2
public class MemberRestController {
    @Autowired
    private MemberRepository memberRepository;
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
        log.info("member => " + member);

        return new ResponseEntity<>(service.registerMember(member), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Integer> updateMemberInfo(@RequestBody Member member)
    {
        log.info("member => " + member);

        return new ResponseEntity<>(service.updateMember(member),HttpStatus.OK);
    }

    @DeleteMapping
    public String withdrawalMember(@RequestParam("id")String id,@RequestParam("password")String password)
    {
        log.info("delete data => " + id, password);
        service.withdrawalMemberByIdAndPassword(id, password);
        return "redirect:/";
    }

}
