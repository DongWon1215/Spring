package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Controller
@Log4j2
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String getloginPage()
    {
        return "login/login";
    }

    @PostMapping
    public String login(String id, String password)
    {
        log.info("실패했다");
//        if()
//        return "/main";
//
//        else
            return "login/login";
    }
}
