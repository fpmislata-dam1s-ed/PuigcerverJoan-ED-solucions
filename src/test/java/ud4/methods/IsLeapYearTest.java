package ud4.methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsLeapYearTest {
    @Test
    void noDivisibleBy4ShouldNotBeLeapYear(){
        // Arrange
        int year = 2019;
        boolean expected = false;

        // Act
        boolean actual = IsLeapYear.isLeapYear(year);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void noBy4ShouldBeLeapYear(){
        // Arrange
        int year = 2020;
        boolean expected = true;

        // Act
        boolean actual = IsLeapYear.isLeapYear(year);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void divisibleBy4AndDivisibleBy100ShouldNotBeLeapYear(){
        // Arrange
        int year = 1900;
        boolean expected = false;

        // Act
        boolean actual = IsLeapYear.isLeapYear(year);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void divisibleBy400ShouldBeLeapYear(){
        // Arrange
        int year = 2000;
        boolean expected = true;

        // Act
        boolean actual = IsLeapYear.isLeapYear(year);

        // Assert
        assertEquals(expected, actual);
    }
}