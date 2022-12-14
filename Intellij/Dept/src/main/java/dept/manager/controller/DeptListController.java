package dept.manager.controller;

import dept.manager.domain.DeptSearchOption;
import dept.manager.service.DeptListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class DeptListController {

    @Autowired
    private DeptListService deptListService;

    @RequestMapping("/dept/list")
    public String getDeptList(DeptSearchOption deptSearchOption, Model model)
    {
        log.info("dept list");
        model.addAttribute("deptList",deptListService.getSearchList(deptSearchOption));

        return "dept/lists";
    }
}