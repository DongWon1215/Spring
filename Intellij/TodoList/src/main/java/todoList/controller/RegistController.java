package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.domain.LoginInfo;
import todoList.domain.TodoFile;
import todoList.service.TodoListService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@Log4j2
@RequestMapping("/page/regist")
public class RegistController {

    //@Autowired
    @Autowired
    private TodoListService todoListService;


    @GetMapping
    public String getRegist()
    {
        return "/page/registPage";
    }

    @PostMapping
    public String addFile(HttpServletRequest request, @RequestParam("title")String title, @RequestParam("dueDate") String dueDate)
    {
        HttpSession session = request.getSession();
        LoginInfo userInfo = (LoginInfo)session.getAttribute("loginInfo");
        String userid = userInfo.getUserId();
        todoListService.insertTodo(TodoFile.builder().userId(userid).title(title).dueDate(LocalDate.parse(dueDate)).build());

        //사용자가 입력한 데이터를 받아와야함
        return "redirect:/page/main";
    }
}
