package com.app.board.Repository;

import com.app.board.Domain.ReplyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyDTO,Integer> {

    @Query("select r from ReplyDTO r where r.bno = :bno")
    List<ReplyDTO> findByBno(@Param("bno") Integer bno);


}
