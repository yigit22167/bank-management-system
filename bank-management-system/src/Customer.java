import java.util.HashMap;
import java.util.Map;

public class Customer implements CustomerInterface {
    private String customerID;
    private String password;
    private String name;
    private String surName;
    private String address;
    private String contactNumber;
    private Map<Integer, Account> accounts;

    // constructor
    public Customer(String customerID, String password, String name, String surName, String address,
            String contactNumber) {
        this.customerID = customerID;
        this.password = password;
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.accounts = new HashMap<>();
    }

    // getters setters
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void createNewAccount(Account account, Integer accountType) {
        accounts.put(accountType, account);
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public void transferMoney(Customer reciever, double amount) {
        // this if-else block controls if both sender and reciever has deposit accounts
        // and proceeds to transfer operation
        if (!reciever.getAccounts().containsKey(1) || !this.accounts.containsKey(1)) {

        } else if (this.accounts.get(1).getBalance() >= amount) {
            double senderBalance = this.accounts.get(1).getBalance();
            this.accounts.get(1).setBalance(senderBalance - amount);
            double recieverBalance = reciever.accounts.get(1).getBalance();
            reciever.accounts.get(1).setBalance(recieverBalance + amount);

        }
    }
}
