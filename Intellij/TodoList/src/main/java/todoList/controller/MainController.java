package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import todoList.service.MainService;

@Controller
@Log4j2
public class MainController {
    @Autowired
    private MainService mainService;
    @RequestMapping("/main")
    public void getmainPage(Model model)
    {
        model.addAttribute("todoList", mainService.getTodoList());
    }

//    @RequestMapping("/main")
//    public
}
