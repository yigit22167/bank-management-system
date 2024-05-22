import java.util.HashMap;

public class CurrencyAccount extends Account {
    private int accountType;

    public CurrencyAccount(String accountID) {
        super(accountID);
        this.accountType = 3;
        this.exchangeRates = new HashMap<>();
        exchangeRates.put("TL", 1.0); // Base currency
        exchangeRates.put("USD", 0.031);
        exchangeRates.put("EUR", 0.028);
        exchangeRates.put("GBP", 0.024);
        exchangeRates.put("JPY", 4.83);
    }

    public int getAccountType() {
        return accountType;
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    public double exchangeCurrency(String fromCurrency, String toCurrency, double amount) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency");
        }
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);

        // Calculate the exchanged amount
        return (amount / fromRate) * toRate;
    }
}
