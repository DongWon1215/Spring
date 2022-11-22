package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.domain.User;
import todoList.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping
    public String getloginPage()
    {
        return "login/login";
    }

    @PostMapping
    public String login(@RequestParam("userId") String id, @RequestParam("userPw") String password, HttpServletRequest request) throws Exception {
        User user = service.login(id,password);

        if(user != null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("loginInfo", user.toLoginInfo());
            return "/main";
        }
        else
            return "login/login";
    }
}
