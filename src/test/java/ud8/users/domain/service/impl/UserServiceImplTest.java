package ud8.users.domain.service.impl;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ud8.common.exception.ResourceNotFoundException;
import ud8.users.domain.entity.User;
import ud8.users.persistance.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private final UserRepository repository = Mockito.mock(UserRepository.class);
    private final UserServiceImpl service = new UserServiceImpl(repository);

    @Nested
    class FindById {
        @Test
        void whenUserExists_shouldReturnUser() throws ResourceNotFoundException {
            User expected = new User(1, "user", "user@localhost");
            when(repository.findById(1)).thenReturn(expected);

            User result = service.findById(1);
            assertEquals(expected, result);
        }
        @Test
        void whenUserDoesNotExist_shouldThrowException() {
            when(repository.findById(2)).thenReturn(null);
            assertThrows(ResourceNotFoundException.class, () -> service.findById(2));
        }
    }

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
            verify(repository, never()).create(user);
        }

        @Test
        void givenValidAlreadyExistsEmail_shouldNotCreate(){
            // Arrange
            User user = new User(1, "test", "exists@localhost");
            when(repository.existsByEmail("exists@localhost")).thenReturn(true);

            // Act
            boolean result = service.create(user);

            // Assert
            assertFalse(result);
            verify(repository, never()).create(user);
        }

        @Test
        void givenValidAndNotExistsEmail_shouldCreate(){
            // Arrange
            User user = new User(1, "test", "no-exists@localhost");
            when(repository.existsByEmail("no-exists@localhost")).thenReturn(false);

            // Act
            boolean result = service.create(user);

            // Assert
            verify(repository).create(user);
            assertTrue(result);
        }
    }
}