package inside.controller.comment;

import inside.domain.CommentDTO;
import inside.service.CommentService;
import inside.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/comment/add")
@Controller
public class CommentAddController {
    @Autowired
    CommentService commentService;


    @PostMapping
    public String insertComment(@RequestParam("id") String writer, @RequestParam("password") String password, @RequestParam("content") String content, @RequestParam("postindex") int index)
    {
        commentService.insertComment(CommentDTO.builder().writer(writer).postindex(index).content(content).password(password).build());

        return "redirect:/page/read?index=" + index;
    }
}
