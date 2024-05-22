import java.util.HashMap;

public interface AccountInterface {
    String getAccountID();

    void setAccountID(String accountID);

    double getBalance();

    void setBalance(double balance);

    String getCurrencyUnit();

    void setCurrencyUnit(String currencyUnit);

    HashMap<String, Double> getExchangeRates();

    void deposit(double amount);

    void withdraw(double amount);
}