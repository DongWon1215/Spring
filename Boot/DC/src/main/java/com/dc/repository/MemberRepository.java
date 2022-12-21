package com.dc.repository;


import com.dc.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Query("select m from Member m where m.authorities = ?1")
    List<Member> findByAuthorities(String authorities);


    @Transactional
    @Modifying
    @Query("delete from Member m where m.id = ?1 and m.password = ?2")
    int deleteByIdAndPassword(String id, String password);




}
