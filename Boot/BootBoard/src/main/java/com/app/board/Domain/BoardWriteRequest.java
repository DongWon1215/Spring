package com.app.board.Domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardWriteRequest {

    private String title;
    private Integer writer;
    private String content;
    private MultipartFile formFile;

//    public BoardDTO toBoardDTO()
//    {
//        return BoardDTO.builder().title(title).writer(writer).content(content).build();
//    }

    public BoardDTO toBoardDTO()
    {
        return BoardDTO.builder().title(title).writer(BoardMember.builder().idx(writer).build()).content(content).build();
    }
}
