package todoList.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Log4j2
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class TodoFile {
    private int index;

    @NonNull
    private String userId;

    @NonNull
    private String title;

    @NonNull
    private LocalDate dueDate;

    private boolean finish;
}
