package dept.manager.service;

import dept.manager.domain.DeptDTO;
import dept.manager.domain.DeptSearchOption;
import dept.manager.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptListService {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    public List<DeptDTO> getList()
    {
        return deptMapper.selectAll();
    }

    public List<DeptDTO> getSearchList(DeptSearchOption searchOption)
    {
        return deptMapper.selectByOption(searchOption);
    }
}
