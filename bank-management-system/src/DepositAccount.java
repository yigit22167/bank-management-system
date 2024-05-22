public class DepositAccount extends Account {
    private int accountType;

    public DepositAccount(String accountID) {
        super(accountID);
        this.accountType = 1;
    }

    public int getAccountType() {
        return accountType;
    }

}