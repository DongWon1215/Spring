package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.domain.TodoFile;
import todoList.service.MainService;
import todoList.service.TodoService;

import java.time.LocalDate;

@Controller
@Log4j2
public class ModifyController {

    @Autowired
    private TodoService todoService;

    @GetMapping("todoList/modifypage")
    public void getModify(Model model, @RequestParam("tno") int tno)
    {
        model.addAttribute("todo", todoService.getTodo(tno));
    }

    @PostMapping
    public String modifyTodo(@RequestParam("index") int index, @RequestParam("userId") String userId, @RequestParam("title") String title,
                             @RequestParam("dueDate")String dueDate, @RequestParam("finish") String finish)
    {
        TodoFile todoFile = new TodoFile(index,userId,title,LocalDate.parse(dueDate),finish == null ? true: false);
        todoService.modifyFile();

        return "redirectL/todoList/main";
    }
}
