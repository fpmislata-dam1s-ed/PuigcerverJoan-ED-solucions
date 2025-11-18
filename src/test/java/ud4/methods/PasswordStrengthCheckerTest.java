package ud4.methods;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ud4.methods.PasswordStrengthChecker.PasswordStrength;
class PasswordStrengthCheckerTest {
    @Nested
    @DisplayName("Medium testcases")
    class MediumTests {
        @Test
        @DisplayName("lower & upper case")
        void lowerAndUpperCaseShouldBeMedium(){
            String password = "aBcDeFgH";
            PasswordStrength expected = PasswordStrength.MEDIUM;

            PasswordStrength actual = PasswordStrengthChecker.checkStrength(password);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("lower case & symbols")
        void lowerCaseAndSymbolsShouldBeMedium(){
            String password = "abc_*def";
            PasswordStrength expected = PasswordStrength.MEDIUM;

            PasswordStrength actual = PasswordStrengthChecker.checkStrength(password);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("upper case & symbols")
        void upperCaseAndSymbolsShouldBeMedium(){
            String password = "ABC_*DEF";
            PasswordStrength expected = PasswordStrength.MEDIUM;

            PasswordStrength actual = PasswordStrengthChecker.checkStrength(password);
            assertEquals(expected, actual);
        }
    }
}