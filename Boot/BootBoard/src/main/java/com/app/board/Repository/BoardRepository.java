package com.app.board.Repository;

import com.app.board.Domain.BoardDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<BoardDTO, Integer>
{
    // 리스트 페이지 : findAll()
    // 뷰 페이지 : findById()
    // 수정 : save()
    // 입력 : save()
    // 삭제 : 별도 method 생성 => return type : int, @Transactional 반드시 추가
    @Transactional
    @Modifying
    @Query("delete from BoardDTO b where b.bno = :bno")       //?1 : 매개변수 중 1번째 매개변수
    int deleteByBno(@Param("bno") Integer bno);                 // :param 명 : 매개변수 중 param명과 동일한 매개변수


}
