package ud4.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private final int NUMBER = 1234;
    private final String HOLDER = "holder";

    @Nested
    class ConstructorTests {
        @Test
        @DisplayName("BankAccount(number, holder, balance)")
        void contructorWithAllParameters() {
            // Arrange
            int number = 1234;
            String holder = "Pep";
            double balance = 10;

            // Act
            BankAccount bankAccount = new BankAccount(number, holder, balance);

            // Assert
            assertAll(
                    () -> assertEquals(number, bankAccount.getNumber()),
                    () -> assertEquals(holder, bankAccount.getHolder()),
                    () -> assertEquals(balance, bankAccount.getBalance())
            );
        }

        @Test
        @DisplayName("BankAccount(number, holder)")
        void contructorWithNumberAndHolder(){
            // Arrange
            int number = 1234;
            String holder = "Pep";

            // Act
            BankAccount bankAccount = new BankAccount(number, holder);

            // Assert
            assertAll(
                    () -> assertEquals(number, bankAccount.getNumber()),
                    () -> assertEquals(holder, bankAccount.getHolder()),
                    () -> assertEquals(0.0, bankAccount.getBalance())
            );
        }
    }

    /*
    @Nested
    class DepositTests {
        @Test
        void positiveAmount(){
            // Arrange
            BankAccount bankAccount = new BankAccount(NUMBER, HOLDER, 10);
            double amount = 10;
            double balanceExpected = 20;

            // Act
            boolean result = bankAccount.deposit(amount);

            // Assert
            assertTrue(result);
            assertEquals(balanceExpected, bankAccount.getBalance());
        }

        @Test
        void negativeAmount(){
            // Arrange
            BankAccount bankAccount = new BankAccount(NUMBER, HOLDER, 10);
            double amount = -10;
            double balanceExpected = 10;

            // Act
            boolean result = bankAccount.deposit(amount);

            // Assert
            assertFalse(result);
            assertEquals(balanceExpected, bankAccount.getBalance());
        }

        // Falta el de 0
    }
     */

    @ParameterizedTest
    @CsvSource({
            "10,10,20,true",
            "10,0,10,false",
            "10,-10,10,false",
    })
    void deposit(double initialBalance, double amount, double expectedBalance, boolean expected){
        // Arrange
        BankAccount bankAccount = new BankAccount(NUMBER, HOLDER, initialBalance);

        // Act
        boolean result = bankAccount.deposit(amount);

        // Assert
        assertAll(
                () -> assertEquals(expected, result),
                () -> assertEquals(expectedBalance, bankAccount.getBalance())
        );
    }

    @ParameterizedTest
    @CsvSource({
            "10,10,0,true",
            "10,0,10,false",
            "10,-10,10,false",
            "10,20,10,false",
    })
    void withdraw(double initialBalance, double amount, double expectedBalance, boolean expected){
        // Arrange
        BankAccount bankAccount = new BankAccount(NUMBER, HOLDER, initialBalance);

        // Act
        boolean result = bankAccount.withdraw(amount);

        // Assert
        assertAll(
                () -> assertEquals(expected, result),
                () -> assertEquals(expectedBalance, bankAccount.getBalance())
       );
    }

    @ParameterizedTest
    @CsvSource({
            "10,10,10,0,20,true",
            "10,10,0,10,10,false",
            "10,10,-10,10,10,false",
            "10,10,20,10,10,false",
    })
    void transfer(double initialBalance1, double initialBalance2, double amount, double expectedBalance1, double expectedBalance2, boolean expected){
        // Arrange
        BankAccount b1 = new BankAccount(NUMBER, HOLDER, initialBalance1);
        BankAccount b2 = new BankAccount(NUMBER, HOLDER, initialBalance2);

        // Act
        boolean result = b1.transfer(b2, amount);

        // Assert
        assertAll(
                () -> assertEquals(expected, result),
                () -> assertEquals(expectedBalance1, b1.getBalance()),
                () -> assertEquals(expectedBalance2, b2.getBalance())
        );
    }
}