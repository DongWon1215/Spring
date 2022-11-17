package todoList.Util;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j2
public class ConnectionProvider {

    private static ConnectionProvider instance = new ConnectionProvider();

    public static ConnectionProvider getInstance()
    {
        if(instance == null)
            instance = new ConnectionProvider();

        return instance;
    }

    public Connection getConnector() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","scott","tiger");

        return conn;
    }
}
