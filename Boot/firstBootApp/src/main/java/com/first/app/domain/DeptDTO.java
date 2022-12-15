package com.first.app.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="dept")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class DeptDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int deptno;

    @Column(length = 20, nullable = false)
    private String dname;

    @Column(length = 20, nullable = false)
    private String loc;
}

// @Future : 현재 시간보다 미래이어야 한다!
// @Email : 이메일 체크
// @NotBlank : 공백 문자열도 체크 " " fail
// @NotNull : Null 값이 아니다