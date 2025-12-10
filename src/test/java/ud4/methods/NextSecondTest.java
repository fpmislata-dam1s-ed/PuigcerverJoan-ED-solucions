package ud4.methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextSecondTest {
    @Test
    void shouldAddSecond(){
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
    void shouldAddMinute(){
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
    void shouldAddMinuteAndKeepRemainingSeconds(){
        // Arrange
        int hours = 0;
        int minutes = 1;
        int seconds = 121;
        String expected = "00:03:02";

        // Act
        String actual = NextSecond.nextSecond(hours, minutes, seconds);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldAddHour(){
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