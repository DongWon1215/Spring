package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import todoList.domain.UserRegRequest;
import todoList.service.UserRegService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/login/memberRegisterPage")
@Log4j2
public class UserRegController {
    @Autowired
    private UserRegService service;

    @GetMapping
    public String getPage()
    {
        return "/login/memberRegisterPage";
    }

    @PostMapping
    public String reg(@Valid UserRegRequest regRequest, BindingResult bindingResult, HttpServletRequest request) throws Exception {
        service.UserReg(regRequest,request);

        if(bindingResult.hasErrors())
            log.info(bindingResult.getAllErrors());

        return "redirect:/login/login";
    }
}
