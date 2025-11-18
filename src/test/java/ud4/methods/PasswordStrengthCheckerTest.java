package ud4.methods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ud4.methods.PasswordStrengthChecker.PasswordStrength;

class PasswordStrengthCheckerTest {
    @Nested
    @DisplayName("Invalid testcases")
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

        @Test
        @DisplayName("Less than 8 characters")
        void lessThan8CharachersPasswordShouldBeInvalid(){
            // ARRANGE
            String password = "ABc123_";
            PasswordStrength expected = PasswordStrength.INVALID;

            // ACT
            PasswordStrength actual = PasswordStrengthChecker.checkStrength(password);

            // ASSERT
            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Weak testcases")
    class WeakTests {
        @Test
        @DisplayName("Lower case")
        void lowerCasePasswordShouldBeWeak(){
            String password = "abcdefgh";
            PasswordStrength expected = PasswordStrength.WEAK;

            PasswordStrength actual = PasswordStrengthChecker.checkStrength(password);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Upper case")
        void upperCasePasswordShouldBeWeak(){
            String password = "ABCDEFGH";
            PasswordStrength expected = PasswordStrength.WEAK;

            PasswordStrength actual = PasswordStrengthChecker.checkStrength(password);
            assertEquals(expected, actual);
        }
    }
}