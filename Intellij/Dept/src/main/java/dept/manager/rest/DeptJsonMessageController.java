package dept.manager.rest;

import dept.manager.domain.DeptDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeptJsonMessageController {

    @GetMapping("/dept/json")
    @ResponseBody
    public List<DeptDTO> listJson()
    {
        List<DeptDTO> list = new ArrayList<>();
        list.add(new DeptDTO(10,"test10","loc10"));
        list.add(new DeptDTO(20,"test20","loc20"));
        list.add(new DeptDTO(30,"test30","loc30"));

        return list;
    }
}
