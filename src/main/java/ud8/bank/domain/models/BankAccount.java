package ud8.bank.domain.models;

public class BankAccount {
    private final String iban;
    private final String holder;
    private double balance;

    public BankAccount(String iban, String holder, double balance) {
        this.iban = iban;
        this.holder = holder;
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }
}
