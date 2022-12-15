package com.first.app.entity;

import com.first.app.domain.DeptDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DeptRepository extends JpaRepository<DeptDTO, Integer> {
    Optional<DeptDTO> findByDeptno(int deptno);

    List<DeptDTO> findByDnameLikeOrderByLocAsc(String dname);

    @Query("select d from DeptDTO d where d.loc like :loc")         //from에 있는 DeptDTO는 table을 의미하는것이 아닌 Entity를 의미
    Optional<DeptDTO> findByLocLike(@Param("loc") String loc);

}