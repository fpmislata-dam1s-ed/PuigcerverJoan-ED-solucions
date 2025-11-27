package exam1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsVowelTest {
    @Nested
    @DisplayName("Tests with vowels")
    class VowelsTests {
        @Test
        @DisplayName("Text with lower case vowels")
        void textLowerCaseVowelsShouldReturnTrue(){
            // Arrange
            String word = "hello";

            // Act
            boolean actual = ContainsVowel.containsVowel(word);

            // Assert
            assertTrue(actual);
        }

        @Test
        @DisplayName("Text with upper case vowels")
        void textUpperCaseVowelsShouldReturnTrue(){
            // Arrange
            String word = "HELLO";

            // Act
            boolean actual = ContainsVowel.containsVowel(word);

            // Assert
            assertTrue(actual);
        }

        @Test
        @DisplayName("Text with upper & lower case vowels")
        void textLowerAndUpperCaseVowelsShouldReturnTrue(){
            // Arrange
            String word = "HelLO";

            // Act
            boolean actual = ContainsVowel.containsVowel(word);

            // Assert
            assertTrue(actual);
        }
    }

    @Nested
    @DisplayName("Tests without vowels")
    class NoVowelsTests {
        @Test
        @DisplayName("empty string")
        void emptyStringShouldReturnFalse() {
            // Arrange
            String word = "";

            // Act
            boolean actual = ContainsVowel.containsVowel(word);

            // Assert
            assertFalse(actual);
        }

        @Test
        @DisplayName("null string")
        void nullStringShouldReturnFalse() {
            // Act
            boolean actual = ContainsVowel.containsVowel(null);

            // Assert
            assertFalse(actual);
        }

        @Test
        @DisplayName("Text with lower case no vowels")
        void textLowerCaseVowelsShouldReturnFalse() {
            // Arrange
            String word = "crypt";

            // Act
            boolean actual = ContainsVowel.containsVowel(word);

            // Assert
            assertFalse(actual);
        }

        @Test
        @DisplayName("Text with upper case no vowels")
        void textUpperCaseVowelsShouldReturnFalse() {
            // Arrange
            String word = "CRYPT";

            // Act
            boolean actual = ContainsVowel.containsVowel(word);

            // Assert
            assertFalse(actual);
        }

        @Test
        @DisplayName("Text with upper & lower case no vowels")
        void textLowerAndUpperCaseVowelsShouldReturnFalse() {
            // Arrange
            String word = "CryPt";

            // Act
            boolean actual = ContainsVowel.containsVowel(word);

            // Assert
            assertFalse(actual);
        }
    }
}