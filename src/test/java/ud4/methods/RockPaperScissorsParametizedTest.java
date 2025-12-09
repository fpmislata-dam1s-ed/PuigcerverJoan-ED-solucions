package ud4.methods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RockPaperScissorsParametizedTest {
    @ParameterizedTest(name="{0} VS {1} -> {2}")
    @CsvSource({
            "pedra,pedra,0",
            "paper,paper,0",
            "tisores,tisores,0",
            "pedra,tisores,1",
            "paper,pedra,1",
            "tisores,paper,1",
            "pedra,paper,2",
            "paper,tisores,2",
            "tisores,pedra,2",
    })
    void pedraVsPedraShouldReturn0(String j1, String j2, int expected){
        // Act
        int actual = RockPaperScissors.guanya(j1, j2);

        // Assert
        assertEquals(expected, actual);
    }
}