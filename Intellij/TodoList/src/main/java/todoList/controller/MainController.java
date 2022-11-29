package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import todoList.domain.LoginInfo;
import todoList.domain.TodoFile;
import todoList.service.TodoListService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
public class MainController {
    @Autowired
    private TodoListService todoListService;
    @RequestMapping("/page/main")
    public String getmainPage(HttpServletRequest request, Model model)
    {
        HttpSession session = request.getSession();
        LoginInfo userInfo = (LoginInfo)session.getAttribute("loginInfo");
        List<TodoFile> list = new ArrayList<>();
        list = todoListService.getTodoList(userInfo.getUserId());
        model.addAttribute("todoList", list);

        return "/page/mainPage";
    }
}
