package com.example.springmvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

    @RequestMapping("/sample")
    public ModelAndView getSamplePage ()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("sample");            // => WEB-INF/views/sample.jsp을 찾음
        return mav;
    }

    @RequestMapping("/sample2")
    public String getStringPage()
    {
        return "sample2";
    }

    @RequestMapping("/sample3")
    public void getVoidPage()
    {

    }
}
