package ud8.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ud8.common.persistance.database.DatabaseConnection;

import java.sql.SQLException;

public class BankAccountJdbcTest {
    private static boolean initialized = false;
    private static final DatabaseConnection connection = DatabaseConnection.getInstance();

    @BeforeAll
    static void setup() throws SQLException {
        if (!initialized){
            connection.executeScript("sql/bank/schema.sql");
            connection.executeScript("sql/bank/data.sql");
            connection.setAutoCommit(false);
            initialized = true;
        }
    }

    @AfterEach
    void rollback() throws SQLException {
        connection.rollback();
    }
}
