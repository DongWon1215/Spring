package dept.manager.service;

import dept.manager.domain.DeptDTO;
import dept.manager.mapper.DeptMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DeptEditService {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    public int editDept(DeptDTO deptDTO)
    {
        return deptMapper.updateDept(deptDTO);
    }
}
