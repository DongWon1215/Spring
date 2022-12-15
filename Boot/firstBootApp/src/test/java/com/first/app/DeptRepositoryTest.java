package com.first.app;

import com.first.app.domain.DeptDTO;
import com.first.app.entity.DeptRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class DeptRepositoryTest {

    @Autowired
    public DeptRepository deptRepository;

    @Test
    public void jpaMotherTest()
    {
        List<DeptDTO> list1 = deptRepository.findAll();
        for (DeptDTO dept : list1)
        {
            log.info(dept);
        }

        log.info("========================================================================================");

        Sort sort = Sort.by(Sort.Direction.DESC,"dname");
        List<DeptDTO> list2 = deptRepository.findAll(sort);
        for (DeptDTO dept : list2)
        {
            log.info(dept);
        }

        //검색
        Optional<DeptDTO> dept1 = deptRepository.findById(10);
        DeptDTO deptData = dept1.orElse(null);

        log.info(deptData);

        log.info("========================================================================================");

        List<Integer> nos = Arrays.asList(10,20,30,40);
        List<DeptDTO> list3 = deptRepository.findAllById(nos);          // where in 연산

        log.info(list3);


        log.info("========================================================================================");


        // insert
        DeptDTO insertData = DeptDTO.builder().dname("rlghlrxla").loc("서울").build();
        log.info(deptRepository.save(insertData));                // 자동으로 증가되는 값을 받아줘야 될 필요성이 있음 따라서 insert 되고 반환되는 객체를 받아준다


        log.info("========================================================================================");


        // Update
        DeptDTO editData = DeptDTO.builder().deptno(61).dname("rufwp").loc("경기").build();
        //log.info("수정된 데이터 값" + deptRepository.save(editData));

        //deptRepository.deleteById(61);

        log.info(deptRepository.count());
    }

    @Test
    public void JpqlMethodTest()
    {
//        DeptDTO dept1 = deptRepository.findByDeptno(30).orElse();
//        log.info(dept1);

        List<DeptDTO> list1 = deptRepository.findByDnameLikeOrderByLocAsc("%A%");

        for(DeptDTO dept : list1)
        {
            log.info(dept);
        }

        log.info("========================================================================================");

    }
}
