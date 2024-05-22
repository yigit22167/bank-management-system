public class SavingAccount extends Account {

    private int accountType;

    public SavingAccount(String accountID) {
        super(accountID);
        this.accountType = 2;
    }

    public int getAccountType() {
        return accountType;
    }

}