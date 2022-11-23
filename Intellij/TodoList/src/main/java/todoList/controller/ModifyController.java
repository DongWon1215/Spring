package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.domain.LoginInfo;
import todoList.domain.TodoFile;
import todoList.service.TodoListService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@Log4j2
public class ModifyController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping("page/modify")
    public String getModify(Model model, @RequestParam("index") int index)
    {
        model.addAttribute("title", todoListService.getTodobyIdx(index));

        return "/page/modifyPage";
    }

    @PostMapping("page/modify")
    public String modify(HttpServletRequest request,
                         @RequestParam("title") String title,
                         @RequestParam("dueDate")String dueDate, @RequestParam("finish") String finish
                         //TodoFile todo
    )
    {
        HttpSession session = request.getSession();
        LoginInfo userInfo = (LoginInfo)session.getAttribute("loginInfo");
        todoListService.modifyTodo(userInfo.getUserId(),title,LocalDate.parse(dueDate),finish == null ? false: true);
        //todoListService.modifyTodo(todo);

        return "redirect:/page/main";
    }
}
