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
    private String writer;
    private String content;
    private MultipartFile formFile;

    public BoardDTO toBoardDTO()
    {
        return BoardDTO.builder().title(title).Writer(writer).content(content).build();
    }
}
