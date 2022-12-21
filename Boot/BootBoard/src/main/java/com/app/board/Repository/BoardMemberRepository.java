package com.app.board.Repository;

import com.app.board.Domain.BoardMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardMemberRepository extends JpaRepository<BoardMember,Integer> {

    //회원 정보 하나 => customUserDetailService
    //회원의 정보, 권한 정보를 가지는 customUser를 반환
    Optional<BoardMember> findByUserid(String userid);




}
