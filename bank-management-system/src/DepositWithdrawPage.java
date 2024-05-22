import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositWithdrawPage {
    private JFrame frame;
    private JRadioButton depositRadioButton;
    private JRadioButton savingRadioButton;
    private JRadioButton currencyRadioButton;
    private JTextField amountField;

    private final String TITLE = "DEUBank";

    public DepositWithdrawPage(Customer currentCustomer) {

        frame = new JFrame("Deposit-Withdraw Money");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));
        frame.setLocationRelativeTo(null);

        JPanel panel1 = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();

        depositRadioButton = new JRadioButton("Deposit account");
        savingRadioButton = new JRadioButton("Saving account");
        currencyRadioButton = new JRadioButton("Currency account");

        buttonGroup.add(depositRadioButton);
        buttonGroup.add(savingRadioButton);
        buttonGroup.add(currencyRadioButton);

        panel1.add(depositRadioButton);
        panel1.add(savingRadioButton);
        panel1.add(currencyRadioButton);

        JPanel panel2 = new JPanel();
        JLabel amountLabel = new JLabel("Enter amount:");
        amountField = new JTextField(15);
        panel2.add(amountLabel);
        panel2.add(amountField);

        JPanel panel3 = new JPanel();
        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String amountText = amountField.getText();
                double amount = Double.parseDouble(amountText);

                // these if-else block basically controls which account is selected and if
                // selected account exists or not
                // then proceeds the deposit operation
                if (depositRadioButton.isSelected()) {
                    if (currentCustomer.getAccounts().get(1) != null) {
                        currentCustomer.getAccounts().get(1).deposit(amount);
                        JOptionPane.showMessageDialog(null,
                                "You deposited " + amount + " TL to your deposit account\n Your new balance is :"
                                        + currentCustomer.getAccounts().get(1).getBalance() + " TL",
                                TITLE,
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "You don't have this account!", TITLE,
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else if (savingRadioButton.isSelected()) {
                    if (currentCustomer.getAccounts().get(2) != null) {
                        currentCustomer.getAccounts().get(2).deposit(amount);
                        JOptionPane.showMessageDialog(null,
                                "You deposited " + amount + " TL to your saving account\n Your new balance is :"
                                        + currentCustomer.getAccounts().get(2).getBalance() + " TL",
                                TITLE,
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "You don't have this account!", TITLE,
                                JOptionPane.ERROR_MESSAGE);
                    }

                } else if (currencyRadioButton.isSelected()) {
                    if (currentCustomer.getAccounts().get(3) != null) {
                        currentCustomer.getAccounts().get(3).deposit(amount);
                        JOptionPane.showMessageDialog(null,
                                "You deposited " + amount + " " + currentCustomer.getAccounts().get(3).getCurrencyUnit()
                                        + " to your currency account\n Your new balance is : "
                                        + currentCustomer.getAccounts().get(3).getBalance() + " "
                                        + currentCustomer.getAccounts().get(3).getCurrencyUnit(),
                                TITLE,
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "You don't have this account!", TITLE,
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an account type!");
                }
                frame.dispose();
            }
        });
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String amountText = amountField.getText();
                double amount = Double.parseDouble(amountText);

                // these if-else block basically controls which account is selected and if
                // selected account exists or not
                // then proceeds the withdraw operation
                if (depositRadioButton.isSelected()) {
                    if (currentCustomer.getAccounts().get(1) != null) {
                        if (currentCustomer.getAccounts().get(1).getBalance() >= amount) { // check amount
                            currentCustomer.getAccounts().get(1).withdraw(amount);
                            JOptionPane.showMessageDialog(null,
                                    "You withdrew " + amount + " TL from your deposit account",
                                    TITLE,
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Amount is not enough", TITLE,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "You don't have this account!", TITLE,
                                JOptionPane.ERROR_MESSAGE);
                    }

                } else if (savingRadioButton.isSelected()) {
                    if (currentCustomer.getAccounts().get(2).getBalance() >= amount) {
                        currentCustomer.getAccounts().get(2).withdraw(amount);
                        JOptionPane.showMessageDialog(null, "You withdrew " + amount + " TL from your saving account",
                                TITLE,
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Amount is not enough", TITLE,
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else if (currencyRadioButton.isSelected()) {
                    if (currentCustomer.getAccounts().get(3).getBalance() >= amount) {
                        currentCustomer.getAccounts().get(3).withdraw(amount);
                        JOptionPane.showMessageDialog(null, "You withdrew " + amount + " " +
                                currentCustomer.getAccounts().get(3).getCurrencyUnit() + " from your currency account",
                                TITLE,
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Amount is not enough", TITLE,
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an account type!");
                }
                frame.dispose();
            }
        });
        panel3.add(depositButton);
        panel3.add(withdrawButton);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);

        frame.setVisible(true);
    }
}
