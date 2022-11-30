package todoList.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;
import todoList.domain.TodoFile;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface TodoMapper {
    List<TodoFile> selectAll();
    List<TodoFile> selectAllById(String userId);
    TodoFile selectById(String userId);
    TodoFile selectByIndex(int index);

    int insertTodo(TodoFile todoFile);
    int updateTodo(int index, String title, LocalDate dueDate, boolean Finish);
    int deleteTodo(int index);
}
