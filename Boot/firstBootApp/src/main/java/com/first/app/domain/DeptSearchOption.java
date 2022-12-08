package com.first.app.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DeptSearchOption {

    private String searchType;  // 부서이름/위치
    private String keyword;     // 키워드
}