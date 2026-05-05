package ud8.bank.unit.persistance.dao.impl;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ud8.bank.BankAccountJdbcTest;
import ud8.bank.domain.entity.BankAccount;
import ud8.bank.persistance.dao.impl.BankAccountDaoJdbc;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountDaoJdbcTest extends BankAccountJdbcTest {
    private BankAccountDaoJdbc dao = new BankAccountDaoJdbc();

    @Nested
    class FindByIBAN {
        @Test
        void givenExistingIBAN_shouldReturnBankAccount(){
            BankAccount expected = new BankAccount("ES01", 1000);
            BankAccount result = dao.findByIBAN("ES01");

            assertEquals(expected, result);
        }

        @Test
        void givenNonExistingIBAN_shouldReturnNull(){
            BankAccount result = dao.findByIBAN("ES00");

            assertNull(result);
        }
    }

    @Nested
    class InsertTests {
       @Test
       void givenNonExistingBankAccount_shouldInsert(){
           BankAccount bankAccount = new BankAccount("ES00", 0);
           int rowsAffected = dao.insert(bankAccount);

           assertEquals(1, rowsAffected);
           BankAccount actual = dao.findByIBAN("ES00");
           assertEquals(bankAccount, actual);
       }
        @Test
        void givenExistingBankAccount_shouldThrowException(){
            BankAccount bankAccount = new BankAccount("ES01", 0);
            assertThrows(RuntimeException.class, () -> dao.insert(bankAccount));
        }
    }

    @Nested
    class Latest {
        @Test
        void shouldReturnLatestBankAccount (){
            BankAccount expected = new BankAccount("ES03", 1000);
            BankAccount result = dao.latest();
            assertEquals(expected, result);
        }
        @Test
        void givenEmptyDatabase_shouldReturnNull (){
            dao.delete("ES01");
            dao.delete("ES02");
            dao.delete("ES03");

            BankAccount result = dao.latest();
            assertNull(result);
        }
    }

    @Nested
    class Delete {
        @Test
        void givenExistingIBAN_shouldDeleteIt(){
            int result = dao.delete("ES01");

            assertEquals(1, result);
            BankAccount bankAccount = dao.findByIBAN("ES01");
            assertNull(bankAccount);
        }
        @Test
        void givenNonExistingIBAN_shouldDeleteNothing(){
            int result = dao.delete("ES00");

            assertEquals(0, result);
        }
    }
}