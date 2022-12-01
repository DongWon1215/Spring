package inside.controller.user;

import inside.domain.UserDTO;
import inside.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login/login")
@Log4j2
public class UserLoginController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getLogin()
    {
        return "login/login";
    }

    @PostMapping
    public String login(@RequestParam("id") String userId, @RequestParam("password") String userPassword, HttpServletRequest httpServletRequest)
    {
        UserDTO userDTO = userService.getUserByIdPassword(userId, userPassword);

        log.info("받아온 유저 정보 = " + userDTO);

        if(userDTO != null)
        {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("loginInfo",userDTO);
            return "redirect:/page/main";
        }

        return "redirect:/login/login";
    }
}
