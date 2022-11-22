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
    private LoginService loginservice;

    @GetMapping
    public String getloginPage()
    {
        return "login/loginPage";
    }

    @PostMapping
    public String login(@RequestParam("userId") String id, @RequestParam("userPw") String password, HttpServletRequest request) throws Exception {
        User user = loginservice.login(id,password);

        log.info("여긴 되겠지");
        if(user != null)
        {
            log.info("여기까진 됨");
            HttpSession session = request.getSession();
            log.info("여기까진 되냐?");
            session.setAttribute("loginInfo", user.toLoginInfo());
            return "redirect:/page/main";
        }
        else
        {
            return "redirect:/login/login";
        }
    }
}
