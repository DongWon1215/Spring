package inside.controller.post;

import inside.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostDeleteController {
    @Autowired
    PostService postService;

    @PostMapping("page/delete")
    public String removeTodo(@RequestParam("index") int index)
    {
        postService.deletePost(index);
        return "redirect:/page/main";
    }
}
