package dept.manager.domain;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DeptDTO {
    @Min(value = 1)
    @Max(value = 99)
    @Positive   //음수가 못들어가게 막는 주석 <-> @Nagative
    private int deptno;

    @NotEmpty   //문자열이 비어있지 않은 상태, 공백 문자도 인식함, List-> 요소의 개수가 비어있는지 체크
    private String dname;

    @NotEmpty
    private String loc;
}

// @Future : 현재 시간보다 미래의 시간을 선택해야 함
// @Email : 이메일 체크, @의 유무만 체크함
// @NotBlank : 공백문자열 유무 체크, ' ' 같은 문자가 있으면 안된다
// @NotNull : null 여부 체크
