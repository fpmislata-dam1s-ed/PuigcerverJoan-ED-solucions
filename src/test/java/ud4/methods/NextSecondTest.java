package ud4.methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextSecondTest {
    @Test
    void shouldAddSeconds(){
        // Arrange
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        String expected = "00:00:01";

        // Act
        String actual = NextSecond.nextSecond(hours, minutes, seconds);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldAddMinutes(){
        // Arrange
        int hours = 0;
        int minutes = 0;
        int seconds = 59;
        String expected = "00:01:00";

        // Act
        String actual = NextSecond.nextSecond(hours, minutes, seconds);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldAddHours(){
        // Arrange
        int hours = 0;
        int minutes = 59;
        int seconds = 59;
        String expected = "01:00:00";

        // Act
        String actual = NextSecond.nextSecond(hours, minutes, seconds);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldResetDay(){
        // Arrange
        int hours = 23;
        int minutes = 59;
        int seconds = 59;
        String expected = "00:00:00";

        // Act
        String actual = NextSecond.nextSecond(hours, minutes, seconds);

        // Assert
        assertEquals(expected, actual);
    }
}