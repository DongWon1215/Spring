package dept.manager.rest;

import dept.manager.domain.DeptDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
@Log4j2
public class ExampleRestController {

    // 메소드의 반환 타입이 String인 경우 -> 문자열 응답이 됨, text 기반
    @GetMapping("/sample1")
    public String sayHello()
    {
        return "Hello~!!";
    }

    // 객체의 반환은 JSON 형식으로 응답
    @GetMapping("/sample2")
    public DeptDTO getDept()
    {
        DeptDTO deptDTO = DeptDTO.builder().deptno(90).dname("Dev").loc("Seoul").build();

        return deptDTO;
    }

    @GetMapping("/sample3")
    public List<DeptDTO> getListDept()
    {
        List<DeptDTO> list = new ArrayList<>();
        list.add(new DeptDTO(10,"test10","loc10"));
        list.add(new DeptDTO(20,"test20","loc20"));
        list.add(new DeptDTO(30,"test30","loc30"));
        list.add(new DeptDTO(40,"test40","loc40"));

        return list;
    }

    @GetMapping({"/sample4"})
    public Map<Integer, DeptDTO> getDeptMap()
    {
        Map<Integer,DeptDTO> map = new HashMap<>();

        map.put(10,new DeptDTO(10,"test10","loc10"));
        map.put(20,new DeptDTO(20,"test20","loc20"));
        map.put(30,new DeptDTO(30,"test30","loc30"));

        return map;
    }
}
