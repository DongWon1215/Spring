package com.example.springmvc.Controller;

import domain.LoginRequest;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@Log4j2
@RequestMapping("/login") //최상단에 경로 명시시 해당 경로가 기본 경로로 설정됨
public class LoginController {

   // @RequestMapping(method = RequestMethod.GET)     //doget과 동일
    @GetMapping
    public String getLoginForm(Model model)
    {
        model.addAttribute("msg","ID와 PW를 반드시 입력하시오");
        return "login/form";                    //WEB-INF/views/login/form.jsp
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String login(String uid, String pw, /*@RequestParam(value = "uid", required = true)*/ @RequestParam(value = "p",defaultValue ="1") String page, HttpServletRequest request,
    HttpServletResponse response ,@ModelAttribute("req") LoginRequest loginRequest, @RequestParam Map paramMap /* 자동적으로 파라미터가 map 형태로 저장됨,*/)
    {
        String uid2 = request.getParameter("uid");
        String pw2 = request.getParameter("pw");

        log.info(request.getSession().getServletContext().getRealPath("/css"));

        log.info("uid =>" + uid);
        log.info("pw =>" + pw);
        log.info("p =>" + page);
        log.info("uid2 =>" + uid2);
        log.info("pw2 =>" + pw2);
        log.info("LoginRequest =>" + loginRequest);
        log.info("paramMap => " + paramMap);

        request.getSession().setAttribute("loginInfo",uid);
        return  "redirect:/mypage/mypage1";
    }

    @GetMapping("/info")                    //http://localhost:8080/login/info
    public String info()
    {
        return "login/info";
    }
}
