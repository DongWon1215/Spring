package com.first.app.domain;

import lombok.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ListItemDTO {
    private Integer empno;
    private String ename;
    private String mgr;
    private String dname;
    private String loc;

}
