package inside.controller.post;

import inside.domain.PostDTO;
import inside.domain.UserDTO;
import inside.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/page/write")
@Controller
public class PostInsertController {
    @Autowired
    PostService postService;

    @GetMapping
    public String getRegist()
    {
        return "/page/write";
    }

    @PostMapping
    public String addFile(HttpServletRequest request, @RequestParam(value = "nickname", required = false) String nickname, @RequestParam(value = "password", required = false) String password, @RequestParam("title")String title, @RequestParam("context") String context)
    {
        HttpSession session = request.getSession();
        UserDTO userInfo = (UserDTO)session.getAttribute("loginInfo");
        if(userInfo != null)
            postService.insertPost(new PostDTO(0,0,title, userInfo.getUserNickName(), userInfo.getUserPassword(),context));

        else
            postService.insertPost(new PostDTO(0,0,title, nickname, password,context));


        return "redirect:/page/main";
    }
}
