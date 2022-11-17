package todoList.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int index;
    private String userId;
    private String userPw;
    private String serialNum;
}
