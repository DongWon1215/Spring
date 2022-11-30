package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.mapper.UserMapper;

@Controller
@Log4j2
@RequestMapping("/user/modify")
public class UserModifyController {

    @Autowired(required = false)
    UserMapper userMapper;

    @GetMapping
    public String getUserData()
    {
        return "/login/memberModify";
    }

    @PostMapping
    public String userModify(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, @RequestParam("userName") String userName, @RequestParam("userPhoto") String userPhoto)
    {
        userMapper.updateUser(userPw, userName, userPhoto, userId);

        return "redirect:/logout";

    }
}
