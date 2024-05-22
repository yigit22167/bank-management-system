import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MainPage {

    private JFrame frame;
    private Customer currentCustomer;
    private final String TITLE = "DEUBank";

    public MainPage(HashMap<String, Customer> bank, String CustomerID) {

        // Setting up frame
        frame = new JFrame(TITLE);
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 2));
        frame.setLocationRelativeTo(null);
        frame.setTitle(TITLE + " ID: " + CustomerID);

        // Get customers data and information
        this.currentCustomer = bank.get(CustomerID);

        // Left Panel
        JPanel leftPanel = new JPanel(new GridLayout(7, 1));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create account component
        JButton createAccountButton = new JButton("CREATE ACCOUNT");
        createAccountButton.setPreferredSize(new Dimension(150, 30));
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Create Account component
                CreateAccountPage createAccountPage = new CreateAccountPage(currentCustomer);
            }
        });
        leftPanel.add(createAccountButton);

        // Deposit - Withdraw component
        JButton depositWithdrawButton = new JButton("DEPOSIT - WITHDRAW");
        depositWithdrawButton.setPreferredSize(new Dimension(150, 30));
        depositWithdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Deposit-Withdraw component
                DepositWithdrawPage depositWithdrawPage = new DepositWithdrawPage(currentCustomer);
            }
        });
        leftPanel.add(depositWithdrawButton);

        JButton transferMoneyButton = new JButton("TRANSFER MONEY");
        transferMoneyButton.setPreferredSize(new Dimension(150, 30));
        transferMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Transfer Money component
                TransferMoneyPage transferMoneyPage = new TransferMoneyPage(bank, CustomerID);
            }
        });
        leftPanel.add(transferMoneyButton);

        JButton exchangeCurrencyButton = new JButton("EXCHANGE CURRENCY");
        exchangeCurrencyButton.setPreferredSize(new Dimension(150, 30));
        exchangeCurrencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Exchange Currency Component
                ExchangeCurrencyPage exchangeCurrencyPage = new ExchangeCurrencyPage(currentCustomer);
            }
        });
        leftPanel.add(exchangeCurrencyButton);

        JPanel rightPanel = new JPanel(new GridLayout(6, 1));

        JButton updateInfoButton = new JButton("UPDATE INFO");
        updateInfoButton.setPreferredSize(new Dimension(150, 30));
        updateInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateInfoPage updateInfoPage = new UpdateInfoPage(currentCustomer, bank, rightPanel);
            }
        });
        leftPanel.add(updateInfoButton);

        JButton showBalanceButton = new JButton("SHOW BALANCE");
        showBalanceButton.setPreferredSize(new Dimension(150, 30));
        showBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowBalancePage showBalancePage = new ShowBalancePage(currentCustomer);
            }
        });
        leftPanel.add(showBalanceButton);

        JButton logoutButton = new JButton("LOG OUT");
        logoutButton.setPreferredSize(new Dimension(150, 30));
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if user clicks exit, bring up login page
                LoginPage loginPage = new LoginPage(bank);
                frame.dispose();
            }
        });
        leftPanel.add(logoutButton);

        // Right panel
        // static customer informations
        rightPanel.setBorder(BorderFactory.createTitledBorder("Customer Info"));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Customer Info"));
        JLabel nameLabel = new JLabel("Name: " + currentCustomer.getName());
        rightPanel.add(nameLabel);

        JLabel surnameLabel = new JLabel("Surname: " + currentCustomer.getSurName());
        rightPanel.add(surnameLabel);

        JLabel customerIDLabel = new JLabel("Customer ID: " + currentCustomer.getCustomerID());
        rightPanel.add(customerIDLabel);

        JLabel passwordLabel = new JLabel("Password: " + currentCustomer.getPassword());
        rightPanel.add(passwordLabel);

        JLabel addressLabel = new JLabel("Address: " + currentCustomer.getAddress());
        rightPanel.add(addressLabel);

        JLabel contactNumberLabel = new JLabel("Contact Number: " + currentCustomer.getContactNumber());
        rightPanel.add(contactNumberLabel);

        frame.add(leftPanel);
        frame.add(rightPanel);

        frame.setVisible(true);
    }

}