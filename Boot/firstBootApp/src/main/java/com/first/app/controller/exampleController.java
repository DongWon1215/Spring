package com.first.app.controller;

import com.first.app.Service.DeptListService;
import com.first.app.Service.DeptReadService;
import com.first.app.domain.DeptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ex")
public class exampleController {

    @Autowired
    private DeptReadService readService;

    @Autowired
    private DeptListService listService;

    @GetMapping("/ex1")
    public String ex1(Model model, HttpSession httpSession)
    {
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");

        model.addAttribute("list",list);

        model.addAttribute("dept",readService.getDept(20));

        model.addAttribute("deptList", listService.getList());

        Map<String, DeptDTO> map = new HashMap<>();
        map.put("10",readService.getDept(10));
        map.put("20",readService.getDept(20));

        model.addAttribute("map",map);
        httpSession.setAttribute("loginData","cool");

        model.addAttribute("localDateTime", LocalDateTime.now());

        model.addAttribute("data","DATA123");
        model.addAttribute("nullData",null);

        return "ex/ex1";
    }
}
