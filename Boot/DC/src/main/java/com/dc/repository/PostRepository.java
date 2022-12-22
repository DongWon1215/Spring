package com.dc.repository;


import com.dc.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("select p from Post p where p.writer = ?1 and p.password = ?2")
    Post findByWriterAndPassword(String writer, String password);

    @Transactional
    @Modifying
    @Query("delete from Post p where p.writer = ?1 and p.password = ?2")
    int deleteByWriterAndPassword(String writer, String password);

}
