package com.app.board.Domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tbl_board")
public class BoardDTO {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;

    @Column
    private String title;

    @Column
    private String writer;

    @Column
    private String content;

    @Column
    private String photo;

    @Column
    private LocalDate regdate;

    @Column
    private LocalDate updatedate;
}
