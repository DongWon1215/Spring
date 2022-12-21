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


    @ManyToOne
    @JoinColumn(name = "writer")
    private BoardMember writer;

    @Column
    private String content;

    @Column
    private String photo;

    @Column(insertable = false,updatable = false)       // 테이블에 입력할 떄 자동으로 입력됨, 데이터 수정시에도 값이 변경되면 안됨
    private LocalDate regdate;

    @Column(insertable = false)                         // 테이블에 입력할 때 자동으로 입력됨,데이터 수정시 값을 변경해야 함
    private LocalDate updatedate;
}
