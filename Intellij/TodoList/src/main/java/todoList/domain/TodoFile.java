package todoList.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;

@Log4j2
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoFile {
    private int index;
    private String userId;
    private String title;
    private LocalDate dueDate;
    private boolean finish;
}
