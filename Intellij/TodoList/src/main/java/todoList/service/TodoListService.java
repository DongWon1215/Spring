package todoList.service;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoList.Util.ConnectionProvider;
import todoList.dao.TodoDAO;
import todoList.domain.TodoFile;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class TodoListService {

    @Autowired
    private TodoDAO dao;

    public TodoFile getTodobyIdx(int index)
    {
        TodoFile todo = null;

        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            todo = dao.selectByIndex(conn,index);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return todo;
    }
    public TodoFile getTodobyId(String userId)
    {
        TodoFile todo = null;

        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            todo = dao.selectById(conn,userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return todo;
    }

    public List<TodoFile> getTodoList()
    {
        List<TodoFile> list = new ArrayList<>();

        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            list = dao.selectAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<TodoFile> getTodoList(String userId)
    {
        List<TodoFile> list = new ArrayList<>();

        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            list = dao.selectAllById(conn,userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public boolean insertTodo(TodoFile todo)
    {
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            dao.insertTodo(conn,todo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean modifyTodo(String userId, String title, LocalDate duedate, Boolean finish)
    {
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            dao.updateTodo(conn,userId,title,duedate,finish);
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
            dao.deleteTodo(conn,userId,index);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
