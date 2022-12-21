package com.dc.dc.Entity;

import lombok.*;

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
    private Integer index;

    @Column
    private String title;

    @Column(updatable = false)
    private String writer;

    @Column(updatable = false)
    private String password;

    @Column
    private String content;

    @Column
    private String category;

    @Column(insertable = false,updatable = false)
    private LocalDate writeDate;

    @Column
    private int suggestion;

}
