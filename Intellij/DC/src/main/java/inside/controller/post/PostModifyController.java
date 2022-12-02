package inside.controller.post;

import inside.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("page/modify")
public class PostModifyController {
    @Autowired
    PostService postService;

    @GetMapping
    public void getModify(Model model, @RequestParam("index") int index)
    {
        model.addAttribute("post", postService.getPostByIndex(index));
    }

    @PostMapping
    public String modify(@RequestParam("index") long index, @RequestParam("password")String password, @RequestParam("content") String content)
    {
        postService.updatePost(index,password,content);

        return "redirect:/page/main";
    }
}
