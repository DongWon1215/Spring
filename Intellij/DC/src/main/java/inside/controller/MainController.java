package inside.controller;

import inside.domain.PostDTO;
import inside.domain.UserDTO;
import inside.service.CommentService;
import inside.service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
public class MainController {

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @RequestMapping("/page/main")
    public String main(Model model)
    {
        List<PostDTO> list = new ArrayList<>();
        list = postService.getPostAll();

        for(PostDTO post : list)
        {
            post.setCommentnum(commentService.getCommentAll(post.getIndex()).size());
        }

//        int commentNum = commentService.getCommentAll().size();

        model.addAttribute("postList",list);


//        model.addAttribute("reply",commentNum);

        return "/page/main";
    }

}
