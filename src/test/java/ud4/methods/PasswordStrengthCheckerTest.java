package ud4.methods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ud4.methods.PasswordStrengthChecker.PasswordStrength;

class PasswordStrengthCheckerTest {
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