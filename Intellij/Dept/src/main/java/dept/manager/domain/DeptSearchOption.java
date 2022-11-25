package dept.manager.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DeptSearchOption {
    private String searchType;      //부서 이름/위치
    private  String keyword;        //keyword

}
