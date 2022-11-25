package dept.manager.mapper;

import dept.manager.domain.DeptDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DeptMapper2 {

    @Select("select * from dept")
    List<DeptDTO> selectAll();

    DeptDTO selectByDeptno(int deptno);

    @Update("update dept set dname = #{dname}, loc= #{loc} where deptnmo = #{deptno}")
    int updateDept(DeptDTO deptDTO);

    int insertDept(DeptDTO deptDTO);

    @Delete("delete dept from deptnmo = #{deptno}")
    int deleteByDeptno(int deptno);
}
