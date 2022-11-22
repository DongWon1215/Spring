package todoList.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import todoList.domain.TodoFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Log4j2
public class TodoDAO {
    public List<TodoFile> selectAll(Connection conn) throws SQLException {

        List<TodoFile> list = new ArrayList<>();

        String sql = " select * from todotable";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next())
        {
            list.add(new TodoFile(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate(),rs.getBoolean(5)));
        }

        return list;
    }

    public TodoFile selectById(Connection conn, String userId) throws SQLException {
        TodoFile todo = null;

        String sql = " select * from todotable where userId = ?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        if(rs.next())
        {
           todo = new TodoFile(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate(),rs.getBoolean(5));
        }

        return todo;
    }
    public TodoFile selectByIndex(Connection conn, int index) throws SQLException {
        TodoFile todo = null;

        String sql = " select * from todotable where index = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        if(rs.next())
        {
            todo = new TodoFile(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate(),rs.getBoolean(5));
        }

        return todo;
    }

    public int insertTodo(Connection conn, TodoFile todoFile) throws SQLException {
        String sql = "insert into todotable(userid,title,duedate,finish) values(?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,todoFile.getUserId());
        pstmt.setString(2,todoFile.getTitle());
        pstmt.setDate(3,java.sql.Date.valueOf(todoFile.getDueDate()));
        pstmt.setBoolean(4,todoFile.isFinish());

        return pstmt.executeUpdate();
    }

    public int updateTodo(Connection conn, String userId, String title, LocalDate dueDate, boolean isFinish) throws SQLException {
        String sql = "update todotable set title = ? , duedate = ?, finish = ? where userId = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,title);
        pstmt.setDate(2,java.sql.Date.valueOf(dueDate));
        pstmt.setBoolean(3,isFinish);
        pstmt.setString(4,userId);

        return pstmt.executeUpdate();
    }

    public int deleteTodo(Connection conn,String userid , int index) throws SQLException {
        String sql = "delete from todotable where index = ? and userid = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,userid);
        pstmt.setInt(2,index);

        return pstmt.executeUpdate();
    }


}
