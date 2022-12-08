package com.first.app.Service;

import com.first.app.domain.DeptDTO;
import com.first.app.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptRegService {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    public int insertDept(DeptDTO deptDTO)
    {
        return deptMapper.insertDept(deptDTO);
    }

}
