package ud8.bank.integration.domain.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ud8.bank.BankAccountJdbcTest;
import ud8.bank.domain.entity.BankAccount;
import ud8.bank.domain.service.NotificationService;
import ud8.bank.domain.service.impl.BankAccountServiceImpl;
import ud8.bank.domain.service.impl.NotificationServiceImpl;
import ud8.bank.persistance.dao.BankAccountDao;
import ud8.bank.persistance.dao.impl.BankAccountDaoJdbc;
import ud8.bank.persistance.repository.BankAccountRepository;
import ud8.bank.persistance.repository.impl.BankAccountRepositoryImpl;
import ud8.common.exception.ResourceNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class BankAccountServiceImplIT extends BankAccountJdbcTest {
    private final BankAccountDao dao = new BankAccountDaoJdbc();
    private final BankAccountRepository repository = new BankAccountRepositoryImpl(dao);
    private final NotificationService notificationService = new NotificationServiceImpl();

    private final BankAccountServiceImpl service = new BankAccountServiceImpl(repository, notificationService);
    private final BankAccount BANK_ACCOUNT = new BankAccount("ES01", 1000);

    @Nested
    class FindByIBAN {
        @Test
        void givenExistingIBAN_shouldReturnBankAccount() throws ResourceNotFoundException {
            // Act
            BankAccount result = service.findByIBAN(BANK_ACCOUNT.getIban());

            // Assert
            assertEquals(BANK_ACCOUNT, result);
        }

        @Test
        void givenNonExistingIBAN_shouldThrowException(){
            // Act & Assert
            assertThrows(ResourceNotFoundException.class, () -> service.findByIBAN("ES00"));
        }
    }

    @Nested
    class GenerateIBAN {
        @Test
        void givenNoOtherAccount_shouldGenerateFirstIBAN(){
            service.delete("ES01");
            service.delete("ES02");
            service.delete("ES03");

            String result = service.generateIBAN();

            assertEquals("ES01", result);
        }
        @Test
        void givenOtherAccounts_shouldGenerateNextIBAN(){
            String result = service.generateIBAN();

            assertEquals("ES04", result);
        }
    }

    @Nested
    class Create {
        @Test
        void shouldCreateBankAccount(){
            BankAccount expected = new BankAccount("ES04", 0);
            BankAccount result = service.create();

            assertEquals(expected, result);
        }
    }

    @Nested
    class Transfer {
        private BankAccount bankAccount1;
        private BankAccount bankAccount2;

        @BeforeEach
        void setup() {
            bankAccount1 = new BankAccount("ES01", 100);
            bankAccount2 = new BankAccount("ES02", 100);
        }

        @ParameterizedTest
        @ValueSource(doubles = {-50, 0, 150})
        void shouldNotTransfer(double amount){
            boolean result = service.transfer(bankAccount1, bankAccount2, amount);

            assertAll (
                    () -> assertFalse(result),
                    () -> assertEquals(100, bankAccount1.getBalance()),
                    () -> assertEquals(100, bankAccount2.getBalance())
            );
        }

        @Test
        void givenLessAmountThanOriginBalance_shouldTransfer(){
            boolean result = service.transfer(bankAccount1, bankAccount2, 50); // 50 < 100

            assertAll (
                    () -> assertTrue(result),
                    () -> assertEquals(50, bankAccount1.getBalance()),
                    () -> assertEquals(150, bankAccount2.getBalance())
            );
        }
    }
}