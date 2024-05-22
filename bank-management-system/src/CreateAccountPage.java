import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountPage {

    // frame elements
    private JFrame frame;
    private JRadioButton depositRadioButton;
    private JRadioButton savingRadioButton;
    private JRadioButton currencyRadioButton;

    Customer currentCustomer;
    private final String TITLE = "DEUBank";

    public CreateAccountPage(Customer currentCustomer) {

        this.currentCustomer = currentCustomer;

        // setting up frame
        frame = new JFrame("Create Account");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));
        frame.setLocationRelativeTo(null);
        JPanel accountButtonsPanel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();

        depositRadioButton = new JRadioButton("Deposit account");
        savingRadioButton = new JRadioButton("Saving account");
        currencyRadioButton = new JRadioButton("Currency account");

        buttonGroup.add(depositRadioButton);
        buttonGroup.add(savingRadioButton);
        buttonGroup.add(currencyRadioButton);

        accountButtonsPanel.add(depositRadioButton);
        accountButtonsPanel.add(savingRadioButton);
        accountButtonsPanel.add(currencyRadioButton);

        JPanel createButtonPanel = new JPanel();

        JButton createButton = new JButton("Create Account");
        createButtonPanel.add(createButton);

        frame.add(accountButtonsPanel);
        frame.add(createButtonPanel);

        frame.setVisible(true);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount(currentCustomer);
                frame.dispose();
            }
        });

    }

    private void createAccount(Customer currentCustomer) {

        // create account which is selected
        if (depositRadioButton.isSelected()) {
            int accountType = 1;
            // check if customer already has that account type
            if (currentCustomer.getAccounts().get(accountType) == null) {
                currentCustomer.createNewAccount(
                        new DepositAccount(currentCustomer.getCustomerID()),
                        accountType);
                JOptionPane.showMessageDialog(null, "you have created a deposit account", TITLE,
                        JOptionPane.INFORMATION_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, "you already have this account type", TITLE,
                        JOptionPane.ERROR_MESSAGE);
        } else if (savingRadioButton.isSelected()) {
            int accountType = 2;
            if (currentCustomer.getAccounts().get(accountType) == null) {
                currentCustomer.createNewAccount(
                        new SavingAccount(currentCustomer.getCustomerID()),
                        accountType);
                JOptionPane.showMessageDialog(null, "you have created a saving account", TITLE,
                        JOptionPane.INFORMATION_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, "you already have this account type", TITLE,
                        JOptionPane.ERROR_MESSAGE);
        } else if (currencyRadioButton.isSelected()) {
            int accountType = 3;
            if (currentCustomer.getAccounts().get(accountType) == null) {
                currentCustomer.createNewAccount(
                        new CurrencyAccount(currentCustomer.getCustomerID()),
                        accountType);
                JOptionPane.showMessageDialog(null, "you have created a currency account", TITLE,
                        JOptionPane.INFORMATION_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, "you already have this account type", TITLE,
                        JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Please select an account type!");
        }
    }
}