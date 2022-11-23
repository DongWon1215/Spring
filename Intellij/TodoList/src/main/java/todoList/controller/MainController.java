package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import todoList.service.TodoListService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
public class MainController {
    @Autowired
    private TodoListService todoListService;
    @RequestMapping("/main")
    public String getmainPage(HttpServletRequest request, Model model)
    {
        HttpSession session = request.getSession();
        String userId = session.getAttribute("loginInfo").toString();
        log.info(userId);
        //model.addAttribute("todoList", );

        return "/page/mainPage";
    }
}
