package ud4.methods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollatzTest {
    @Nested
    @DisplayName("f(int) tests")
    class FunctionTests {
        @Test
        @DisplayName("f(4) -> 2")
        void givenEvenNumberShouldDivideBy2(){
            int n = 4;
            int expected = 2;

            int actual = Collatz.f(n);
            assertEquals(expected, actual);
        }
        @Test
        @DisplayName("f(5) -> 16")
        void givenOddNumberShouldMultuplyBy3AndAdd1(){
            int n = 5;
            int expected = 16;

            int actual = Collatz.f(n);
            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("collatz(int) tests")
    class StepTests {
        @Test
        @DisplayName("collatz(-2) -> -1")
        void givenNegativeNumberShouldReturnError(){
            int n = -2;
            int expected = -1;

            int actual = Collatz.collatz(n);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("collatz(0) -> -1")
        void givenZeroShouldReturnError(){
            int n = 0;
            int expected = -1;

            int actual = Collatz.collatz(n);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("collatz(1) -> 0")
        void givenOneShouldReturnZero(){
            int n = 1;
            // 1 is already 1
            int expected = 0;

            int actual = Collatz.collatz(n);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("collatz(4) -> 2")
        void givenFourShouldReturnTwo(){
            int n = 4;
            // 4 -> 2 (1) -> 1 (2)
            int expected = 2;

            int actual = Collatz.collatz(n);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("collatz(3) -> 7")
        void givenThreeShouldReturnSeven(){
            int n = 3;
            // 3 -> 10 (1) -> 5 (2) -> 16 (3) -> 8 (4)
            // -> 4 (5) -> 2 (6) -> 1 (7)
            int expected = 7;

            int actual = Collatz.collatz(n);
            assertEquals(expected, actual);
        }
    }
}