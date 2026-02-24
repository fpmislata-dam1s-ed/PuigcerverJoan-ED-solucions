package ud4.objects;

public class BankAccount {
    private final int number;
    private final String holder;
    private double balance;

    public BankAccount(int number, String holder, double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public BankAccount(int number, String holder) {
        this.number = number;
        this.holder = holder;
        this.balance = 0.0;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount){
        if (amount <= 0)
            return false;

        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount){
        if (amount <= 0 || this.balance < amount)
            return false;

        this.balance -= amount;
        return true;
    }

    public boolean transfer(BankAccount other, double amount){
        if(this.withdraw(amount)){
            other.deposit(amount);
            return true;
        }
        return false;
    }
}
