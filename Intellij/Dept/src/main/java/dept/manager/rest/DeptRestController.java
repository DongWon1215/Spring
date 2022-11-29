package dept.manager.rest;

import dept.manager.domain.DeptDTO;
import dept.manager.service.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/v1/depts")
public class DeptRestController {

    @Autowired
    private DeptListService deptListService;

    @Autowired
    private DeptReadService deptReadService;

    @Autowired
    private DeptRegService deptRegService;

    @Autowired
    private DeptEditService deptEditService;

    @Autowired
    private DeptDeleteService deptDeleteService;

    // get => 전체 리스트
    @GetMapping
    public List<DeptDTO> getDeptList()
    {
        return deptListService.getList();
    }

    // get / {no} => 부서 no의 정보
    @GetMapping("/{no}")
    public DeptDTO getDept(@PathVariable("no") int deptno)
    {
        log.info("deptno = " + deptno);

        return deptReadService.getDept(deptno);
    }

    // post => json 형식의 데이터를(파일을) 받아서 입력처리
    @PostMapping
    public ResponseEntity<String> regDept(
            @RequestBody DeptDTO deptDTO
    )
    //ResponseEntity<String> : 응답 데이터를 제네릭으로 정의
    // 객체 -> 응답 데이터, http header, http status code
    {
        log.info(deptDTO);

        deptRegService.insertDept(deptDTO);

        //header 정의
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("some-header","some-value");

//        return new ResponseEntity<>("insert OK", HttpStatus.OK);
        return new ResponseEntity<>("insert OK", httpHeaders,HttpStatus.OK);
    }

    // put / {no} => no의 부서정보를 수정, 모든 데이터를 수정 or 갱신함
    @PutMapping("/{no}")
    public HttpEntity<String> editDept(@PathVariable("no") int deptno ,@RequestBody DeptDTO deptDTO)
    {

        deptEditService.editDept(deptDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("some-header","some-value");

        return new HttpEntity<>("Update",httpHeaders);
    }

    // delete / {no} => 부서 no의 정보 삭제
    @DeleteMapping("/{no}")
    public HttpEntity<String> deleteDept(@PathVariable("no") int deptno)
    {
        deptDeleteService.deleteDept(deptno);

        return new ResponseEntity<>("delete OK", HttpStatus.OK);
    }
}
