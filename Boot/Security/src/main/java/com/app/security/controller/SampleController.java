package com.app.security.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

    @GetMapping("/all")
    public void all()
    {
        log.info("all");
    }

    @GetMapping("/sample")
    public void sample()
    {
        log.info("sample");
    }

    @GetMapping("/admin")
    public void admin()
    {
        log.info("admin");
    }

    @GetMapping("/member")
    public void member()
    {
        log.info("member");
    }

    @GetMapping("/login")
    public void login()
    {

    }
}
