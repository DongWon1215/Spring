package dept.manager.mapper;

import dept.manager.domain.DeptDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    List<DeptDTO> selectAll();

    DeptDTO selectByDeptno(int deptno);

    int updateDept(DeptDTO deptDTO);

    int insertDept(DeptDTO deptDTO);

    int deleteByDeptno(int deptno);
}
