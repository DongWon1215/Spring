package inside.controller.post;

import inside.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostReadController {
    @Autowired
    PostService postService;

    @GetMapping("/page/read")
    public void readTodo(Model model, @RequestParam("index") int index)
    {
        postService.readPost(index);
        model.addAttribute("post", postService.getPostByIndex(index));
    }
}
