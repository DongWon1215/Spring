package todoList.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.domain.TodoFile;
import todoList.service.RegistService;

import java.time.LocalDate;

@Controller
@Log4j2
@RequestMapping("/todoList/regist")
public class RegistController {

    //@Autowired
    private final RegistService registService;

    public RegistController(RegistService registService) {
        this.registService = registService;
    }

    @GetMapping
    public String getRegist()
    {
        return "page/registpage";
    }

    @PostMapping
    public String addFile(@RequestParam("title")String title,@RequestParam("dueDate") String dueDate)
    {
        TodoFile todoFile = TodoFile.builder().title(title).dueDate(LocalDate.parse(dueDate)).build();

        //사용자가 입력한 데이터를 받아와야함
        return "redirect:/page/mainpage";
    }
}
