package inside.controller;

import inside.domain.PostDTO;
import inside.domain.UserDTO;
import inside.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    PostService postService;

    @RequestMapping("/page/main")
    public String main(Model model)
    {
        List<PostDTO> list = new ArrayList<>();
        list = postService.getPostAll();

        model.addAttribute("postList",list);

        return "/page/main";
    }

}
