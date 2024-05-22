import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class TransferMoneyPage {

    // frame elements
    private JFrame frame;
    private JTextField accountNumberField;
    private JTextField amountField;

    // customer and bank
    private Customer currentCustomer;
    private HashMap<String, Customer> bank = new HashMap<String, Customer>();

    // strings that are used more than once
    private final String TITLE = "DEUBank";
    private final String ACCOUNT_NOT_FOUND = "The account is not found";
    private final String OWN_ACCOUNT_ERROR = "You can not transfer money to your account";
    private final String AMOUNT_NOT_ENOUGH = "Amount is not enough for transfer";

    public TransferMoneyPage(HashMap<String, Customer> bank, String customerID) {

        this.bank = bank;
        this.currentCustomer = bank.get(customerID);

        // setting up frame
        frame = new JFrame("Transfer Money");
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));
        frame.setLocationRelativeTo(null);

        JPanel notePanel = new JPanel();
        JLabel noteLabel = new JLabel("Note: Transfer operations are carried out only from the deposit account");
        notePanel.add(noteLabel);

        JPanel accountNumberPanel = new JPanel();
        JLabel accountNumberLabel = new JLabel("Enter account number:");
        accountNumberField = new JTextField(20);
        accountNumberPanel.add(accountNumberLabel);
        accountNumberPanel.add(accountNumberField);

        JPanel amountPanel = new JPanel();
        JLabel amountLabel = new JLabel("Enter amount to transfer:");
        amountField = new JTextField(20);
        amountPanel.add(amountLabel);
        amountPanel.add(amountField);

        JPanel buttonPanel = new JPanel();
        JButton transferButton = new JButton("Transfer Money");

        buttonPanel.add(transferButton);
        frame.add(notePanel);
        frame.add(accountNumberPanel);
        frame.add(amountPanel);
        frame.add(buttonPanel);

        frame.setVisible(true);

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountNumberField.getText();
                double amount = Double.parseDouble(amountField.getText());
                transferMoney(accountNumber, amount);
                frame.dispose();
            }
        });

    }

    private void transferMoney(String recieverID, double amount) {
        Customer reciever = bank.get(recieverID);
        // if reciever doesn't exist
        if (reciever == null) {
            JOptionPane.showMessageDialog(null, ACCOUNT_NOT_FOUND, TITLE, JOptionPane.ERROR_MESSAGE);
        } // if reciever doesn't have deposit account
        else if (reciever.getAccounts().get(1) == null) {
            JOptionPane.showMessageDialog(null, ACCOUNT_NOT_FOUND, TITLE, JOptionPane.ERROR_MESSAGE);
        } // if sender is trying to send money to his/her own account
        else if (recieverID.equals(currentCustomer.getCustomerID())) {
            JOptionPane.showMessageDialog(null, OWN_ACCOUNT_ERROR, TITLE,
                    JOptionPane.ERROR_MESSAGE);
        } // check if amount is enough, then proceed to the transfer operation
        else {
            if (amount <= currentCustomer.getAccounts().get(1).getBalance()) {
                currentCustomer.transferMoney(reciever, amount);
                JOptionPane.showMessageDialog(null,
                        "You have transferred " + amount + " to account number: " + recieverID
                                + "\nYour new balance is: " + currentCustomer.getAccounts().get(1).getBalance(),
                        "Bank",
                        JOptionPane.INFORMATION_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, AMOUNT_NOT_ENOUGH, TITLE,
                        JOptionPane.ERROR_MESSAGE);
        }
    }

}