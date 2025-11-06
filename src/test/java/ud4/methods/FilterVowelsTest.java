package ud4.methods;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterVowelsTest {
    @Nested
    class Minuscules {
        @Test
        void shouldRemoveLowerCaseA(){
            // Arrange
            String string = "casa";
            String expected = "cs";

            // Act
            String actual = FilterVowels.filterVowels(string);

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void shouldRemoveLowerCaseE(){
            // Arrange
            String string = "Pep";
            String expected = "Pp";

            // Act
            String actual = FilterVowels.filterVowels(string);

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void shouldRemoveLowerCaseI(){
            // Arrange
            String string = "piripi";
            String expected = "prp";

            // Act
            String actual = FilterVowels.filterVowels(string);

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void shouldRemoveLowerCaseO(){
            // Arrange
            String string = "loco";
            String expected = "lc";

            // Act
            String actual = FilterVowels.filterVowels(string);

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void shouldRemoveLowerCaseU(){
            // Arrange
            String string = "lulu";
            String expected = "ll";

            // Act
            String actual = FilterVowels.filterVowels(string);

            // Assert
            assertEquals(expected, actual);
        }

    }

    @Nested
    class Majuscules {
        @Test
        void shouldRemoveUpperCaseA(){
            // Arrange
            String string = "CArA";
            String expected = "Cr";

            // Act
            String actual = FilterVowels.filterVowels(string);

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void shouldRemoveUpperCaseE(){
            // Arrange
            String string = "PEP";
            String expected = "PP";

            // Act
            String actual = FilterVowels.filterVowels(string);

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void shouldRemoveUpperCaseI(){
            // Arrange
            String string = "PIRIPI";
            String expected = "PRP";

            // Act
            String actual = FilterVowels.filterVowels(string);

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void shouldRemoveUpperCaseO(){
            // Arrange
            String string = "LOCO";
            String expected = "LC";

            // Act
            String actual = FilterVowels.filterVowels(string);

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        void shouldRemoveUpperCaseU(){
            // Arrange
            String string = "LULU";
            String expected = "LL";

            // Act
            String actual = FilterVowels.filterVowels(string);

            // Assert
            assertEquals(expected, actual);
        }
    }

    @Nested
    class MinusculesAccents {
        @Test
        void shouldRemoveLowerCaseAWithAccent() {
            // Arrange
            String string = "cásà";
            String expected = "cs";

            // Act
            String actual = FilterVowels.filterVowels(string);

            // Assert
            assertEquals(expected, actual);
        }
    }
}