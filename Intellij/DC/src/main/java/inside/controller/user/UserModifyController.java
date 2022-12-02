package inside.controller.user;

import inside.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login/modify")
public class UserModifyController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getModify()
    {
        return "/login/modify";
    }

    @PostMapping
    public String Modify(@RequestParam("id") String userId,@RequestParam("password") String password,@RequestParam("name") String nickname,@RequestParam("photo") MultipartFile photo, HttpServletRequest request)
    {
        userService.updateUser(userId, password, nickname, photo,request);

        return "redirect:/logout";
    }
}
