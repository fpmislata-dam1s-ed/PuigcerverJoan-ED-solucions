package ud8.users.domain.service.impl;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ud8.users.domain.entity.User;
import ud8.users.persistance.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private final UserRepository repository = Mockito.mock(UserRepository.class);
    private final UserServiceImpl service = new UserServiceImpl(repository);

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