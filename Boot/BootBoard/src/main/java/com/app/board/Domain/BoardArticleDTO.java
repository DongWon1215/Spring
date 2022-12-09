package com.app.board.Domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardArticleDTO {
    private int bno;
    private int replycnt;
    private String title;
    private String writer;
    private String content;
    private String photo;
    private LocalDate regdate;
    private LocalDate updatedate;
}
