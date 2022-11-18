package todoList.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;
import todoList.Util.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
@Service
public class RegistService {

    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    Connection conn;

    {
        try {
            conn = ctx.getBean("Conn",ConnectionProvider.class).getConnector();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
