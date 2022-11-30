package todoList.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoList.domain.TodoFile;
import todoList.mapper.TodoMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class TodoListService {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    public TodoFile getTodobyIdx(int index)
    {
        TodoFile todo = null;

        try {
            todo = todoMapper.selectByIndex(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todo;
    }
    public TodoFile getTodobyId(String userId)
    {
        TodoFile todo = null;

        try {
            todo = todoMapper.selectById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todo;
    }
    public List<TodoFile> getTodoList()
    {
        List<TodoFile> list = new ArrayList<>();

        try {
            list = todoMapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<TodoFile> getTodoList(String userId)
    {
        List<TodoFile> list = new ArrayList<>();

        try {
            list = todoMapper.selectAllById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean insertTodo(TodoFile todo)
    {
        try {
            log.info("todo 객체 : " + todo);
            todoMapper.insertTodo(todo);
            log.info("일단 성공적으로 집어넣음");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean modifyTodo(int index, String title, LocalDate dueDate, Boolean finish)
    {
        try {
            todoMapper.updateTodo(index,title,dueDate,finish);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteTodo(int index)
    {
        try {
            todoMapper.deleteTodo(index);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
