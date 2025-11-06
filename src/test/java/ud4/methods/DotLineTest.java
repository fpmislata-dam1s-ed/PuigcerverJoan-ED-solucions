package ud4.methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DotLineTest {
    @Test
    void empty(){
        // Arrange
        int length = 0;
        String expected = "";

        // Act
        String actual = DotLine.dotLine(length);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void one(){
        // Arrange
        int length = 1;
        String expected = ".";

        // Act
        String actual = DotLine.dotLine(length);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void two(){
        // Arrange
        int length = 2;
        String expected = "..";

        // Act
        String actual = DotLine.dotLine(length);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void ten(){
        // Arrange
        int length = 10;
        String expected = "..........";

        // Act
        String actual = DotLine.dotLine(length);

        // Assert
        assertEquals(expected, actual);
    }
}