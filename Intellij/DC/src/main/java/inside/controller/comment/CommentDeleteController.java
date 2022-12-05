package inside.controller.comment;

import inside.service.CommentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class CommentDeleteController {
    @Autowired
    CommentService commentService;

    @PostMapping("/comment/delete")
    public String deleteComment(@RequestParam("postIndex") int postIndex ,@RequestParam("index") int index, @RequestParam("password") String password)
    {
        commentService.deleteComment(index, password);

        return "redirect:/page/read?index=" + postIndex;
    }
}
