package todoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import todoList.domain.UserRegRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserRegController {

    @PostMapping
    public String reg(UserRegRequest regRequest, HttpServletRequest request)
    {


        return "/login/login";
    }
}
