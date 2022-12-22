package com.dc.domain;

import com.dc.entity.Post;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostWriteRequest {

    private String title;
    private String writer;
    private String password;
    private String content;
    private MultipartFile img;
    private LocalDate writeDate;

    public Post toPost()
    {
        return Post.builder().title(title).writer(writer).password(password).content(content).writeDate(writeDate).build();
    }
}
