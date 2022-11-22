package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@Log4j2
public class LogOutController {
    @GetMapping
    public String logout(HttpSession httpSession)
    {
        httpSession.invalidate();

        return "redirect:/main";
    }
}
