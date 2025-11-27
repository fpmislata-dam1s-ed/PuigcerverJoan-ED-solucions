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
}