package dept.manager.controller;

import dept.manager.service.DeptReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dept/edit")
public class DeptEditController
{

    @Autowired
    private DeptReadService deptReadService;

    @GetMapping
    public void getEditForm(@RequestParam("no") int deptno,
                            Model model)
    {
        model.addAttribute("dept",deptReadService.getDept(deptno));
    }

    @PostMapping
    public String edit()
    {
        return "redirect:/dept/list";
    }
}
