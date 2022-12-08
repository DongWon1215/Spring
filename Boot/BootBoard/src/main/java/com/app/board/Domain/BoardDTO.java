package com.app.board.Domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardDTO {

    private int bno;
    private String title;
    private String Writer;
    private String content;
    private String photo;
    private LocalDate regdate;
    private LocalDate updatedate;
}
