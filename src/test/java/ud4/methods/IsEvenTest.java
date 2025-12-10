package ud4.methods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsEvenTest {
    @Test
    @DisplayName("isEven(4) -> true")
    void givenEvenNumber_shouldReturnTrue(){
        // Arrange
        int n = 4;

        // Act
        boolean actual = IsEven.isEven(n);

        // Assert
        assertTrue(actual);
    }

    @Test
    @DisplayName("isEven(3) -> false")
    void givenOddNumber_shouldReturnFalse(){
        // Arrange
        int n = 3;

        // Act
        boolean actual = IsEven.isEven(n);

        // Assert
        assertFalse(actual);
    }
}