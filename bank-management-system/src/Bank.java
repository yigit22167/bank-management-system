import java.util.HashMap;

public class Bank {

    private HashMap<String, Customer> bank;

    public Bank() {
        bank = new HashMap<String, Customer>();
    }

    public HashMap<String, Customer> getBank() {
        return bank;
    }

}
