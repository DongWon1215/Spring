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
@RequestMapping("/login/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping
    public String getloginPage()
    {
        log.info("로그인 페이지로 왔다");
        return "login/login";
    }

    @PostMapping
    public String login(@RequestParam("userId") String id, @RequestParam("userPw") String password, HttpServletRequest request) throws Exception {
        User user = service.login(id,password);

        log.info("포스트 메세진 들어왔다");
        if(user != null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("loginInfo", user.toLoginInfo());
            log.info("난 간다");
            return "/main";
        }
        else
        {
            log.info("이걸 못가네");
            return "login/login";
        }
    }
}
