package com.app.board.Domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardEditRequest {

    private int bno;
    private int curPageNum;
    private String title;
    private String writer;
    private String content;
    private String oldFile;
    private MultipartFile formFile;

    public BoardDTO toBoardDTO()
    {
        return BoardDTO.builder().bno(bno).writer(writer).title(title).content(content).photo(oldFile).build();
    }
}
