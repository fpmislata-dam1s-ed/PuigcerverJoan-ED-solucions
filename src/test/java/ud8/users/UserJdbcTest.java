package ud8.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ud8.common.persistance.database.DatabaseConnection;
import ud8.users.domain.service.impl.UserServiceImpl;
import ud8.users.persistance.dao.impl.UserDaoJdbc;
import ud8.users.persistance.repository.impl.UserRepositoryImpl;

import java.sql.SQLException;

public class UserJdbcTest {
    private static DatabaseConnection connection;
    private static boolean initialized = false;

    @BeforeAll
    static void setup() throws SQLException {
        if (!initialized){
            connection = DatabaseConnection.getInstance();

            connection.executeScript("sql/user/schema.sql");
            connection.executeScript("sql/user/data.sql");
            connection.setAutoCommit(false);
            initialized = true;
        } else {
            System.out.println("Already initialized");
        }
    }
    @AfterEach
    void rollback() throws SQLException {
        connection.rollback();
    }

}
