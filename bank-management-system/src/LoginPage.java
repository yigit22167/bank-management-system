import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class LoginPage implements ActionListener {
    private JFrame frame;
    private JButton loginButton;
    private JButton resetButton;
    private JButton signupButton;
    private JTextField userIDField;
    private JPasswordField userPasswordField;
    private JLabel userIDLabel;
    private JLabel userPasswordLabel;
    private JLabel messageLabel;
    private HashMap<String, Customer> bank;

    LoginPage(HashMap<String, Customer> bank) {
        this.bank = bank;

        // setting up frame
        frame = new JFrame("Login Page");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.getContentPane().setBackground(new Color(243, 249, 253));
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        messageLabel = new JLabel("LOGIN PAGE");
        messageLabel.setBounds(150, 50, 250, 35);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 28));
        frame.add(messageLabel);

        userIDLabel = new JLabel("User ID:");
        userIDLabel.setBounds(50, 120, 75, 25);
        userIDLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(userIDLabel);

        userPasswordLabel = new JLabel("Password:");
        userPasswordLabel.setBounds(50, 170, 75, 25);
        userPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(userPasswordLabel);

        userIDField = new JTextField();
        userIDField.setBounds(150, 120, 200, 25);
        frame.add(userIDField);

        userPasswordField = new JPasswordField();
        userPasswordField.setBounds(150, 170, 200, 25);
        frame.add(userPasswordField);

        signupButton = new JButton("Sign Up");
        signupButton.setBounds(50, 230, 120, 35);
        signupButton.setBackground(new Color(83, 186, 224)); // Buton arka plan rengi
        signupButton.setForeground(Color.WHITE); // Buton yazı rengi
        signupButton.setFont(new Font("Arial", Font.BOLD, 16)); // Buton yazı fontu
        signupButton.setFocusable(false);
        signupButton.addActionListener(this);
        frame.add(signupButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(180, 230, 120, 35);
        loginButton.setBackground(new Color(83, 186, 224)); // Buton arka plan rengi
        loginButton.setForeground(Color.WHITE); // Buton yazı rengi
        loginButton.setFont(new Font("Arial", Font.BOLD, 16)); // Buton yazı fontu
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        frame.add(loginButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(310, 230, 120, 35);
        resetButton.setBackground(new Color(83, 186, 224)); // Buton arka plan rengi
        resetButton.setForeground(Color.WHITE); // Buton yazı rengi
        resetButton.setFont(new Font("Arial", Font.BOLD, 16)); // Buton yazı fontu
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        frame.add(resetButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (bank.containsKey(userID) && bank.get(userID).getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL!!", "", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                MainPage mainPage = new MainPage(bank, userID);
            } else {
                JOptionPane.showMessageDialog(null, "INVALID ID OR PASSWORD!!", "", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == signupButton) {
            SignUpPage signUpPage = new SignUpPage(bank);
            bank = signUpPage.getBank();
        }
    }

}
