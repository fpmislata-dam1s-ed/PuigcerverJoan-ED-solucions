package ud4.methods;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ud4.methods.PasswordStrengthChecker.PasswordStrength;

class PasswordStrengthCheckerTest {
    @Nested
    @DisplayName("Strong testcases")
    class StrongTests {
        @Test
        @DisplayName("lower & upper case & symbols")
        void lowerAndUpperCaseAndSymbolsShouldBeStrong(){
            String password = "aBc*/DeF";
            PasswordStrength expected = PasswordStrength.STRONG;


            PasswordStrength actual = PasswordStrengthChecker.checkStrength(password);
            assertEquals(expected, actual);
        }
    }
}