package com.first.app.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/ajax/form")
    public void getForm()
    {

    }

    @GetMapping("/parameter")
    @ResponseBody
    public String getParameter(@RequestParam("name") String name, @RequestParam("price") String price)
    {
        String result = name + " : " + price;
        log.info(result);

        return result;
    }
}
