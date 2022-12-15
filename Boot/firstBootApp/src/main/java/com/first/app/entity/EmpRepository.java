package com.first.app.entity;

import com.first.app.domain.ListItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmpRepository extends JpaRepository<Emp, Integer> {

    @Query(value = "select e from Emp e join fetch e.dept")           //Eml : entity 이름
    List<Emp> findEmpDept();

    @Query("select e from Emp e, DeptDTO d where e.dept=d")
    Page<Emp> findEmpWithDept(Pageable pageable);

    @Query(value = "select " + "d , count(e) " + "from Emp e left outer join DeptDTO d " + "on e.dept=d" + " group by d ", countQuery = "select count(d) from DeptDTO d")
    public Page<Object[]> listWithCnt(Pageable pageable);

    @Query("select new com.first.app.domain.ListItemDTO(e.empno, e.ename, e.job, d.dname, d.loc) from Emp e, DeptDTO d where e.dept = d")             //sql과는 다르게 대소문자 구분함
    List<ListItemDTO> findListItem();
}
