package ud8.users.domain.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ud8.common.exception.ResourceNotFoundException;
import ud8.common.persistance.database.DatabaseConnection;
import ud8.users.UserJdbcTest;
import ud8.users.domain.entity.User;
import ud8.users.persistance.dao.UserDao;
import ud8.users.persistance.dao.impl.UserDaoJdbc;
import ud8.users.persistance.repository.UserRepository;
import ud8.users.persistance.repository.impl.UserRepositoryImpl;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplIT extends UserJdbcTest {
    private static final User USER = new User(1, "User", "user@fpmislata.com");

    private static UserDao dao = new UserDaoJdbc();
    private static UserRepository repository = new UserRepositoryImpl(dao);
    private static UserServiceImpl service = new UserServiceImpl(repository);

    @Nested
    class Create {
        @Test
        void givenInvalidEmail_shouldNotCreate(){
            // Arrange
            User user = new User(1, "test", "invalid-email");

            // Act
            boolean result = service.create(user);

            // Assert
            assertFalse(result);
        }

        @Test
        void givenValidAlreadyExistsEmail_shouldNotCreate(){
            // Act
            boolean result = service.create(USER);

            // Assert
            assertFalse(result);
        }

        @Test
        void givenValidAndNotExistsEmail_shouldCreate() throws ResourceNotFoundException {
            // Arrange
            User user = new User(2, "new-user", "new-user@localhost");

            // Act
            boolean result = service.create(user);

            // Assert
            assertTrue(result);
            User newUser = service.findById(2);
            assertEquals(user, newUser);
        }
    }
}