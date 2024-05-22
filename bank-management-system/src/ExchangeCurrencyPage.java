import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ExchangeCurrencyPage {
    private JFrame frame;
    private JLabel balanceLabel;
    private JComboBox<String> toCurrencyBox;
    private JButton exchangeButton;

    private final String TITLE = "DEUBank";
    private String currencyUnit;
    private HashMap<String, Double> exchangeRates;
    private Customer currentCustomer;
    private double currentBalance;

    public ExchangeCurrencyPage(Customer currentCustomer) {

        this.currentCustomer = currentCustomer;
        this.currentBalance = currentCustomer.getAccounts().get(3).getBalance();
        this.currencyUnit = currentCustomer.getAccounts().get(3).getCurrencyUnit();
        this.exchangeRates = currentCustomer.getAccounts().get(3).getExchangeRates();

        // Set up the frame
        frame = new JFrame("Currency Exchange");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        // Balance label
        balanceLabel = new JLabel("You have " + currentBalance + " " + currencyUnit + " in your currency account");
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        balanceLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(balanceLabel, gbc);

        // "From" label and field
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        JLabel fromLabel = new JLabel("From: " + currencyUnit);
        fromLabel.setHorizontalAlignment(JLabel.RIGHT);
        frame.add(fromLabel, gbc);

        // "To" label and combobox
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel toLabel = new JLabel("To:");
        toLabel.setHorizontalAlignment(JLabel.RIGHT);
        frame.add(toLabel, gbc);

        gbc.gridx = 1;
        toCurrencyBox = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
        frame.add(toCurrencyBox, gbc);

        // Exchange button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        exchangeButton = new JButton("Exchange");
        exchangeButton.setFont(new Font("Arial", Font.BOLD, 14));
        exchangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentCustomer.getAccounts().get(3) != null) {
                    exchangeCurrency();
                } else {
                    JOptionPane.showMessageDialog(null, "You don't have a currency account!", TITLE,
                            JOptionPane.ERROR_MESSAGE);
                }

                frame.dispose();
            }
        });
        frame.add(exchangeButton, gbc);

        // Show the frame
        frame.setVisible(true);
    }

    private void exchangeCurrency() {
        String fromCurrency = currencyUnit;
        String toCurrency = toCurrencyBox.getSelectedItem().toString();

        if (toCurrency == null) {
            JOptionPane.showMessageDialog(frame, "Please select a target currency", "Invalid input",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);

        // exchange all the current balance
        double result = (currentBalance / fromRate) * toRate;
        JOptionPane.showMessageDialog(frame,
                "You have exchanged " + currentBalance + " " + fromCurrency + " to " + result + " " + toCurrency);
        currentBalance = result;
        balanceLabel.setText("You have " + currentBalance + currencyUnit + " in your currency account");

        this.currentCustomer.getAccounts().get(3).setCurrencyUnit(toCurrency);
        this.currentCustomer.getAccounts().get(3).setBalance(result);

    }
}
