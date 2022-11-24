import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/baseContext.xml")
public class test {

    @Autowired
    private DataSource dataSource;

    public void connectionTest() throws SQLException {
        Connection connection = dataSource.getConnection();

        log.info(connection);

        Assertions.assertNotNull(connection);


        connection.close();
    }
}