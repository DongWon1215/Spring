package com.first.app.entity;

import com.first.app.domain.DeptDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "emp")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer empno;

    @Column
    private String ename;

    @Column
    private String job;

    @Column
    private Integer mgr;  // 상사의 사원번호

    @Column
    private LocalDate hiredate;

    @Column
    private Double sal;

    @Column
    private Double comm;

    /*@Column
    private Integer deptno;*/

    @JoinColumn(name = "deptno")
    @ManyToOne
    private DeptDTO dept;
}