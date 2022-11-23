package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import todoList.domain.LoginInfo;
import todoList.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequestMapping("/withdrawal")
public class WithdrawalController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public String withdrawal(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        LoginInfo userInfo = (LoginInfo)session.getAttribute("loginInfo");

        loginService.withdrawal(userInfo.getUserId());
        return "/login/login";
    }
}
