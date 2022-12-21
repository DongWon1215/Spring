package com.dc.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "post")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column
    private String title;

    @Column(updatable = false)
    private String writer;

    @Column(updatable = false)
    private String password;

    @Column
    private String content;

    @Column
    private String category;        // 게시판

    @Column
    private String img;

    @Column(insertable = false,updatable = false)
    private LocalDate writeDate;

    @Column
    @ColumnDefault("0")
    private int recommend;          // 개추 수

    @Column
    @ColumnDefault("0")
    private int views;              // 조회 수

}
