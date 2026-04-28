package ud8.bank.persistance.repository;

import ud8.bank.domain.models.BankAccount;

public interface BankAccountRepository{
    BankAccount findByIBAN(String iban);
}
