import java.util.HashMap;

public abstract class Account implements AccountInterface {
    protected String accountID;
    protected double balance;
    protected String currencyUnit;
    protected HashMap<String, Double> exchangeRates;

    public Account(String accountID) {
        this.accountID = accountID;
        this.balance = 0;
        this.currencyUnit = "TL";
    }

    public HashMap<String, Double> getExchangeRates() {
        return exchangeRates;
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (this.balance >= amount)
            this.balance -= amount;
        else
            System.out.println("There is not enough money in your account.");
    }
}
