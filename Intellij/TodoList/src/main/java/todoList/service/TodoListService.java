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
            todoMapper.insertTodo(todo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean modifyTodo(String userId, String title, LocalDate duedate, Boolean finish)
    {
        try {
            todoMapper.updateTodo(userId,title,duedate,finish);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean deleteTodo(String userId, int index)
    {
        try {
            todoMapper.deleteTodo(userId,index);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
