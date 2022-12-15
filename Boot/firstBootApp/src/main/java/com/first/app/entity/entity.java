package com.first.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "dept")
public class entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Deptno;


}
