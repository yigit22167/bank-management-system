import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ShowBalancePage {

    private JFrame frame;
    private Customer currentCustomer;

    public ShowBalancePage(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;

        // setting up frame
        frame = new JFrame("Show Balance");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);

        // setting up frame elements
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        JPanel accountListPanel = new JPanel();
        JTextArea accountListArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(accountListArea);
        accountListPanel.add(scrollPane);

        JPanel buttonPanel = new JPanel();
        JButton showBalanceButton = new JButton("Show Balance");
        buttonPanel.add(showBalanceButton);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 3.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        frame.add(accountListPanel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 1.0;
        frame.add(buttonPanel, gbc);

        frame.setVisible(true);

        showBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBalance(accountListArea);
            }
        });
    }

    private void showBalance(JTextArea accountListArea) {
        StringBuilder sb = new StringBuilder();
        sb.append("Account Balances:\n");
        Map<Integer, Account> accounts = currentCustomer.getAccounts();
        for (Map.Entry<Integer, Account> entry : accounts.entrySet()) {
            int accountType = entry.getKey();
            Account account = entry.getValue();
            sb.append("Account Type: ");
            switch (accountType) {
                case 1:
                    sb.append("Deposit Account\n");
                    break;
                case 2:
                    sb.append("Saving Account\n");
                    break;
                case 3:
                    sb.append("Currency Account\n");
                    break;
                default:
                    sb.append("Unknown Account Type\n");
            }
            sb.append("Balance: ").append(account.getBalance() + " " + account.getCurrencyUnit()).append("\n\n");
        }
        accountListArea.setText(sb.toString());
    }
}