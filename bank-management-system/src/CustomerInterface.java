import java.util.Map;

public interface CustomerInterface {
    String getCustomerID();

    void setCustomerID(String customerID);

    String getPassword();

    void setPassword(String password);

    String getName();

    void setName(String name);

    String getSurName();

    void setSurName(String surName);

    String getAddress();

    void setAddress(String address);

    String getContactNumber();

    void setContactNumber(String contactNumber);

    void createNewAccount(Account account, Integer accountType);

    Map<Integer, Account> getAccounts();

    void transferMoney(Customer receiver, double amount);
}