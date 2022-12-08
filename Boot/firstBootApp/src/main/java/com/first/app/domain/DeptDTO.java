package com.first.app.domain;

import lombok.*;

import javax.validation.constraints.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DeptDTO {

    private int deptno;

    private String dname;

    private String loc;
}

// @Future : 현재 시간보다 미래이어야 한다!
// @Email : 이메일 체크
// @NotBlank : 공백 문자열도 체크 " " fail
// @NotNull : Null 값이 아니다