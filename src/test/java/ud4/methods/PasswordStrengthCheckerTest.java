package ud4.methods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ud4.methods.PasswordStrengthChecker.PasswordStrength;

class PasswordStrengthCheckerTest {
    @Nested
    @DisplayName("Invalid tests")
    class InvalidTests {
        @Test
        @DisplayName("Null password")
        void nullPasswordShouldBeInvalid(){
            // ARRANGE
            String password = null;
            PasswordStrength expected = PasswordStrength.INVALID;

            // ACT
            PasswordStrength actual = PasswordStrengthChecker.checkStrength(password);

            // ASSERT
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Empty password")
        void emptyPasswordShouldBeInvalid(){
            // ARRANGE
            String password = "";
            PasswordStrength expected = PasswordStrength.INVALID;

            // ACT
            PasswordStrength actual = PasswordStrengthChecker.checkStrength(password);

            // ASSERT
            assertEquals(expected, actual);
        }
    }
}