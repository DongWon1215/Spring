package todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.service.MainService;

@Controller
public class ReadController {

    @Autowired
    private MainService mainService;

    @GetMapping("/todoList/read")
    public void readTodo(Model model, @RequestParam("tno") int tno)
    {
        model.addAttribute("todoList", mainService.getTodo(tno));

        //return "/todoList/read";
    }
}
