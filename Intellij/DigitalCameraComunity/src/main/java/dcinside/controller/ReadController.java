package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.service.TodoListService;

@Controller
@Log4j2
public class ReadController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping("/page/read")
    public String readTodo(Model model, @RequestParam("index") int index)
    {
        model.addAttribute("todoList", todoListService.getTodobyIdx(index));

        return "/page/readPage";
    }
}
