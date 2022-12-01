package inside.controller.comment;

import inside.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class CommentAddController {
    @Autowired
    CommentService commentService;
}
