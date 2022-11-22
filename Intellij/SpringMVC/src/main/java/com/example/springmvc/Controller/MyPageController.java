package com.example.springmvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @GetMapping("/mypage1")
    public String getMyPage1()
    {

        return "mypage/mypage1";
    }
    @GetMapping("/mypage2")
    public String getMyPage2()
    {

        return "mypage/mypage2";
    }
    @GetMapping("/mypage3")
    public String getMyPage3()
    {

        return "mypage/mypage3";
    }
}
