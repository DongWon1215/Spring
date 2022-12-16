package com.app.board.Domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tbl_reply")
public class ReplyDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer rno;

    @Column
    private Integer bno;

    @Column
    private String reply;

    @Column
    private String replyer;

    @Column(insertable = false,updatable = false)
    private String replydate;

    @Column(insertable = false)
    private String updatedate;
}
