package ud8.bank.unit.domain.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ud8.bank.domain.entity.BankAccount;
import ud8.bank.domain.service.NotificationService;
import ud8.bank.domain.service.impl.BankAccountServiceImpl;
import ud8.bank.persistance.repository.BankAccountRepository;
import ud8.common.exception.ResourceNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BankAccountServiceImplTest {
    private final BankAccountRepository repository = Mockito.mock(BankAccountRepository.class);
    private final NotificationService notificationService = Mockito.mock(NotificationService.class);
    private final BankAccountServiceImpl service = new BankAccountServiceImpl(repository, notificationService);
    private final BankAccount BANK_ACCOUNT = new BankAccount("ES01", 10);

    @Nested
    class FindByIBAN {
        @Test
        void givenExistingIBAN_shouldReturnBankAccount() throws ResourceNotFoundException {
            // Arrange
            when(repository.findByIBAN(BANK_ACCOUNT.getIban())).thenReturn(BANK_ACCOUNT);

            // Act
            BankAccount result = service.findByIBAN(BANK_ACCOUNT.getIban());

            // Assert
            assertSame(BANK_ACCOUNT, result);
        }

        @Test
        void givenNonExistingIBAN_shouldThrowException(){
            // Arrange
            when(repository.findByIBAN(BANK_ACCOUNT.getIban())).thenReturn(null);

            // Act & Assert
            assertThrows(ResourceNotFoundException.class, () -> service.findByIBAN(BANK_ACCOUNT.getIban()));
        }
    }

    @Nested
    class GenerateIBAN {
        @Test
        void givenNoOtherAccount_shouldGenerateFirstIBAN(){
            when(repository.latest()).thenReturn(null);

            String result = service.generateIBAN();

            assertEquals("ES01", result);

        }
        @Test
        void givenOtherAccounts_shouldGenerateNextIBAN(){
            when(repository.latest()).thenReturn(BANK_ACCOUNT); // ES01

            String result = service.generateIBAN();

            assertEquals("ES02", result);
        }
    }

    @Nested
    class Create {
        @Test
        void shouldCreateBankAccount(){
            BankAccount result = service.create();

            assertNotNull(result);
            verify(repository).save(result);
            verify(notificationService).sendNotification(eq(result), anyString());
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
                () -> assertEquals(100, bankAccount2.getBalance()),
                () -> verify(repository, never()).save(bankAccount1),
                () -> verify(repository, never()).save(bankAccount2),
                () -> verify(notificationService, never()).sendNotification(eq(bankAccount1), anyString()),
                () -> verify(notificationService, never()).sendNotification(eq(bankAccount2), anyString())
            );
        }

        @Test
        void givenLessAmountThanOriginBalance_shouldTransfer(){
            boolean result = service.transfer(bankAccount1, bankAccount2, 50); // 50 < 100

            assertAll (
                    () -> assertTrue(result),
                    () -> assertEquals(50, bankAccount1.getBalance()),
                    () -> assertEquals(150, bankAccount2.getBalance()),
                    () -> verify(repository).save(bankAccount1),
                    () -> verify(repository).save(bankAccount2),
                    () -> verify(notificationService).sendNotification(eq(bankAccount1), anyString()),
                    () -> verify(notificationService).sendNotification(eq(bankAccount2), anyString())
            );
        }
    }
}