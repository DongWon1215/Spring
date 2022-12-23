package com.dc.domain;

import com.dc.entity.Comment;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CommentWriteRequest {
    private String writer;
    private String password;
    private String content;
    private MultipartFile img;
    private LocalDate writeDate;

    public Comment toComment()
    {
        return Comment.builder().writer(writer).password(password).content(content).writeDate(writeDate).build();
    }
}
