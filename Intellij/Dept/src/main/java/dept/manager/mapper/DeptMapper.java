package dept.manager.mapper;

import dept.manager.domain.DeptDTO;
import dept.manager.domain.DeptSearchOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    List<DeptDTO> selectAll();

    //검색 타입과 키워드를 받아서 검색 결과를 반환
    List<DeptDTO> selectByOption(DeptSearchOption searchOption);

    List<DeptDTO> selectByDeptnos(List<Integer> deptnos);

    DeptDTO selectByDeptno(int deptno);

    int updateDept(DeptDTO deptDTO);

    int insertDept(DeptDTO deptDTO);

    int deleteByDeptno(int deptno);
}
