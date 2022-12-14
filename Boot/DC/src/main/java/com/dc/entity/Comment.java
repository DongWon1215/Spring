package com.dc.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column
    private Integer postIndex;

    @Column(updatable = false)
    private String writer;

    @Column(updatable = false)
    private String password;

    @Column
    private String content;

    @Column(updatable = false)
    private String img;

    @Column(insertable = false,updatable = false)
    private LocalDate writeDate;

}
