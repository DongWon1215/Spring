package inside.controller.user;

import inside.domain.UserDTO;
import inside.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/login/regist")
public class UserRegisterController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getPage()
    {
        return "/login/regist";
    }

    @PostMapping
    public String reg(@RequestParam("id") String userId, @RequestParam("password") String userPassword, @RequestParam("name")String nickname, @RequestParam("photo")
    MultipartFile photo,  HttpServletRequest request) throws Exception {

        log.info("여긴 회원가입 페이지");
        log.info(userId + userPassword);

        if(userId.matches("/^[a-zA-Z0-9]"))
            return "redirect:error/loginfail";



        //userService.insertUser(userId, userPassword, nickname, photo,request);

        return "redirect:/login/login";
    }

}
