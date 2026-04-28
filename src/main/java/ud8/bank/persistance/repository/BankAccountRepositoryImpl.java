package ud8.bank.persistance.repository;

import ud8.bank.domain.models.BankAccount;
import ud8.bank.persistance.dao.BankAccountDAO;

public class BankAccountRepositoryImpl implements BankAccountRepository {
    private BankAccountDAO dao;

    public BankAccountRepositoryImpl(BankAccountDAO dao) {
        this.dao = dao;
    }

    public BankAccount findByIBAN(String iban){
        return dao.select(iban);
    }
}
