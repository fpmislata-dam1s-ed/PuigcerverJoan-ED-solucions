package ud8.bank.domain.service;

import ud8.bank.domain.models.BankAccount;
import ud8.bank.persistance.repository.BankAccountRepository;

public class BankAccountService {
    private BankAccountRepository repository;

    public BankAccountService(BankAccountRepository repository) {
        this.repository = repository;
    }

    public BankAccount findByIBAN(String iban) {
        if (iban == null)
            return null;

        return repository.findByIBAN(iban);
    }
}