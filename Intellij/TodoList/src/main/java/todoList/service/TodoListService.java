package todoList.service;

import lombok.Cleanup;
import org.springframework.stereotype.Service;
import todoList.Util.ConnectionProvider;
import todoList.dao.TodoDAO;
import todoList.domain.TodoFile;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

@Service
public class TodoListService {

    private TodoDAO todoDAO;

    public TodoFile getTodo(int index)
    {
        TodoFile todo = null;

        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            todo = todoDAO.selectByIndex(conn,index);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return todo;
    }

    public List<TodoFile> getTodoList()
    {
        List<TodoFile> list = null;

        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            list = todoDAO.selectAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public boolean insertTodo(TodoFile todo)
    {
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            todoDAO.insertTodo(conn,todo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    } public boolean modifyTodo(String userId, String title, LocalDate duedate, Boolean finish)
    {
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            todoDAO.updateTodo(conn,userId,title,duedate,finish);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean deleteTodo(String userId, int index)
    {
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            todoDAO.deleteTodo(conn,userId,index);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
