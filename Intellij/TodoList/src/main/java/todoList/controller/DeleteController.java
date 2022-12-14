package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.domain.LoginInfo;
import todoList.service.TodoListService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
public class DeleteController {

    @Autowired
    private TodoListService todoListService;

    @PostMapping("page/delete")
    public String removeTodo(@RequestParam("index") int index)
    {
        todoListService.deleteTodo(index);
        return "redirect:/page/main";
    }
}
