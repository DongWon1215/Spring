package com.dc.repository;


import com.dc.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPostIndex(Integer postIndex);

    @Transactional
    @Modifying
    @Query("delete from Comment c where c.writer = ?1 and c.password = ?2 and c.idx = ?3")
    int deleteByWriterAndPassword(String writer, String password, int idx);

    @Transactional
    @Modifying
    @Query("delete from Comment c where c.writer = ?1 and c.password = ?2")
    int deleteByWriterAndPassword(String writer, String password);

    @Transactional
    @Modifying
    @Query("delete from Comment c where c.postIndex = ?1")
    int deleteByPostIndex(Integer postIndex);


}
