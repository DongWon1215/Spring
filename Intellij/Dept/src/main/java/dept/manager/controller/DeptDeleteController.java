package dept.manager.controller;

import dept.manager.domain.DeptDTO;
import dept.manager.service.DeptDeleteService;
import dept.manager.service.DeptRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequestMapping("/dept/delete")
public class DeptDeleteController {

    @Autowired
    private DeptDeleteService deptDeleteService;

    @GetMapping
    public String getDelForm(@RequestParam("deptno") int deptno)
    {
        deptDeleteService.deleteDept(deptno);
        return "redirect:/dept/list";
    }

}
