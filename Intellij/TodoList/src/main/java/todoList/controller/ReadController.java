package todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.service.TodoListService;

@Controller
public class ReadController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping("/todoList/read")
    public void readTodo(Model model, @RequestParam("tno") int tno)
    {
        model.addAttribute("todoList", todoListService.getTodo(tno));

        //return "/todoList/read";
    }
}
