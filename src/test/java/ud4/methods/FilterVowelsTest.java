package ud4.methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterVowelsTest {
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
}