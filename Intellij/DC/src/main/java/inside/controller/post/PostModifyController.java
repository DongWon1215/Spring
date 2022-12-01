package inside.controller.post;

import inside.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PostModifyController {
    @Autowired
    PostService postService;

    @GetMapping("page/modify")
    public void getModify(Model model, @RequestParam("index") int index)
    {
        model.addAttribute("post", postService.getPostByIndex(index));
    }

    @PostMapping("page/modify")
    public String modify(@RequestParam("index") long index ,@RequestParam("title") String title,
                         @RequestParam("password")String password, @RequestParam("content") String content)
    {
        postService.updatePost(index,title,password,content );

        return "redirect:/page/main";
    }
}
