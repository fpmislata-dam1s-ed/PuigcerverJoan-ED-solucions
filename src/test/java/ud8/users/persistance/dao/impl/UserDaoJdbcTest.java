package ud8.users.persistance.dao.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ud8.common.exception.ResourceNotFoundException;
import ud8.users.UserJdbcTest;
import ud8.users.domain.entity.User;
import ud8.users.persistance.dao.UserDao;
import ud8.users.persistance.dao.impl.UserDaoJdbc;
import ud8.common.persistance.database.DatabaseConnection;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoJdbcTest extends UserJdbcTest {
    private static final User USER = new User(1, "User", "user@fpmislata.com");
    private static UserDao userDao = new UserDaoJdbc();

    @Nested
    class FindByIdTests {
        @Test
        void givenExistingId_shouldReturnUser() throws ResourceNotFoundException {
            // Act
            User actual = userDao.findById(USER.getId());

            // Assert
            assertEquals(USER, actual);
        }

        @Test
        void givenNonExistingId_shouldReturnNull() {
            // Act
            User actual = userDao.findById(0);

            // Assert
            assertNull(actual);
        }
    }

    @Nested
    class FindByEmailTests {
        @Test
        void givenExistingEmail_shouldReturnUser() throws ResourceNotFoundException {
            // Act
            User actual = userDao.findByEmail(USER.getEmail());

            // Assert
            assertEquals(USER, actual);
        }

        @Test
        void givenNonExistingEmail_shouldReturnNull() {
            // Act
            User actual = userDao.findByEmail("inexistent@fpmislata.com");

            // Assert
            assertNull(actual);
        }
    }

    @Nested
    class InsertTests {
        @Test
        void givenUser_shouldInsertUser() throws ResourceNotFoundException {
            // Arrange
            User user = new User("New user", "newuser@fpmislata.com");

            // Act
            int rowsAffected = userDao.insert(user);

            // Assert
            assertEquals(1, rowsAffected);

            User actual = userDao.findByEmail(user.getEmail());
            assertAll(
                    () -> assertEquals(user.getName(), actual.getName()),
                    () -> assertEquals(user.getEmail(), actual.getEmail())
            );
        }

        @Test
        void givenExistingEmail_shouldThrowException() {
            // Act & Assert
            assertThrows(RuntimeException.class, () -> {
                userDao.insert(USER);
            });

        }
    }

    @Nested
    class UpdateTests {
        @Test
        void givenUser_shouldUpdateUser() throws ResourceNotFoundException {
            // Arrange
            User user = new User(USER.getId(), "Updated user", "updated@fpmislata.com");

            // Act
            int rowsAffected = userDao.update(user);

            // Assert
            assertEquals(1, rowsAffected);

            User actual = userDao.findById(user.getId());
            assertEquals(user, actual);
        }

        @Test
        void givenNonExistingUser_shouldAffectZeroRows() {
            // Arrange
            User user = new User(0, "Updated user", "updated@fpmislata.com");

            // Act
            int rowsAffected = userDao.update(user);

            // Assert
            assertEquals(0, rowsAffected);
        }
    }

    @Nested
    class DeleteTests {
        @Test
        void givenExistingId_shouldDeleteUser() throws ResourceNotFoundException {
            // Act
            int rowsAffected = userDao.delete(USER.getId());

            // Assert
            assertEquals(1, rowsAffected);

            User actual = userDao.findById(USER.getId());
            assertNull(actual);
        }

        @Test
        void givenNonExistingId_shouldAffectZeroRows() {
            // Act
            int rowsAffected = userDao.delete(0);

            // Assert
            assertEquals(0, rowsAffected);
        }
    }
}
