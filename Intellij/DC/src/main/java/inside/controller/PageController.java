package inside.controller;

import inside.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    PageService pageService;

    @GetMapping("/main/list")
    public void getList()
    {
        
    }

}
