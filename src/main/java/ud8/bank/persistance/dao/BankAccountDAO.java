package ud8.bank.persistance.dao;


import ud8.bank.domain.models.BankAccount;

public class BankAccountDAO {
    public BankAccount select(String iban){
        String sql = "SELECT iban, holder, balance FROM bank_account";
        return null;
    }
}
