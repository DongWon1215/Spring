package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import todoList.service.TodoListService;

@Controller
@Log4j2
public class MainController {
    @Autowired
    private TodoListService todoListService;
    @RequestMapping("/main")
    public String getmainPage(Model model)
    {
        model.addAttribute("todoList", todoListService.getTodoList());

        return "/page/mainPage";
    }

//    @RequestMapping("/main")
//    public
}
