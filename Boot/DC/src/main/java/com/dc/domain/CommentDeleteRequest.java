package com.dc.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CommentDeleteRequest {
    private String id;
    private String password;
    private int idx;
}
