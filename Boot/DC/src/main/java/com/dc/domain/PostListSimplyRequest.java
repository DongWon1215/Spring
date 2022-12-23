package com.dc.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostListSimplyRequest {
    private int curNum;
    private int countPerPage;
}
