package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.service.TodoListService;

@Controller
@Log4j2
public class DeleteController {

    @Autowired
    private TodoListService todoListService;

    @PostMapping("todoList/delete")
    public String removeTodo(@RequestParam("tno") int tno)
    {
        return "redirect:/todoList/main";
    }
}
