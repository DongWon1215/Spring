package com.dc.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Member")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer unequeCode;

    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    private String authorities;

}
