package inside.controller;

import inside.domain.PageDTO;
import inside.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    PageService pageService;

    @GetMapping("/main/list")
    public void getList(@RequestParam(value = "page",defaultValue = "1")int page, Model model)
    {
        PageDTO pageDTO = pageService.selectPostPage(page);

        model.addAttribute("page", pageDTO);
    }

}
