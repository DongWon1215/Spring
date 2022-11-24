package dept.manager.controller;

import dept.manager.domain.DeptDTO;
import dept.manager.service.DeptRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/dept/register")
public class DeptRegController {

    @Autowired
    private DeptRegService deptRegService;

    @GetMapping
    public void getRegForm()
    {

    }

    @PostMapping
    public String reg(
            DeptDTO deptDTO    )
    {
        log.info(deptDTO);

        deptRegService.insertDept(deptDTO);

        return  "redirect:/dept/list";
    }
}
