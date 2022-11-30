package todoList.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Log4j2
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class TodoFile {
    private int index;

    @NotEmpty
    private String userId;

    @NotNull
    private String title;

    private LocalDate dueDate;

    private boolean finish;
}
