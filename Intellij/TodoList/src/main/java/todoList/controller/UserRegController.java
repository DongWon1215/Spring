package todoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import todoList.domain.UserRegRequest;
import todoList.service.UserRegService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login/memberRegisterPage")
public class UserRegController {

    private UserRegService service;

    @GetMapping
    public String getPage()
    {
        return "/login/memberRegisterPage";
    }

    @PostMapping
    public String reg(UserRegRequest regRequest, HttpServletRequest request) throws Exception {
        service.UserReg(regRequest,request);

        return "redirect:/main";
    }
}
