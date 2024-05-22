import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SignUpPage implements ActionListener {

    // frame elements
    private JFrame frame = new JFrame();
    private JButton signUpButton = new JButton("Sign Up");
    private JTextField userIDField = new JTextField();
    private JPasswordField userPasswordField = new JPasswordField();
    private JTextField nameField = new JTextField();
    private JTextField surnameField = new JTextField();
    private JTextField addressField = new JTextField();
    private JTextField contactNumberField = new JTextField();
    private JLabel userIDLabel = new JLabel("User ID (4-digit number):");
    private JLabel userPasswordLabel = new JLabel("Password:");
    private JLabel nameLabel = new JLabel("Name:");
    private JLabel surnameLabel = new JLabel("Surname:");
    private JLabel addressLabel = new JLabel("Address:");
    private JLabel contactNumberLabel = new JLabel("Contact Number (only digits):");
    private JLabel messageLabel = new JLabel("SIGN UP PAGE");

    private HashMap<String, Customer> bank;

    SignUpPage(HashMap<String, Customer> bank) {
        this.bank = bank;

        // setting up frame
        frame.getContentPane().setBackground(new Color(243, 249, 253));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Signup Page");

        // setting up frame elements
        // adding elements to frame
        userIDLabel.setBounds(50, 50, 150, 25);
        userIDField.setBounds(200, 50, 200, 25);
        frame.add(userIDLabel);
        frame.add(userIDField);

        userPasswordLabel.setBounds(50, 90, 75, 25);
        userPasswordField.setBounds(200, 90, 200, 25);
        frame.add(userPasswordLabel);
        frame.add(userPasswordField);

        nameLabel.setBounds(50, 130, 75, 25);
        nameField.setBounds(200, 130, 200, 25);
        frame.add(nameLabel);
        frame.add(nameField);

        surnameLabel.setBounds(50, 170, 75, 25);
        surnameField.setBounds(200, 170, 200, 25);
        frame.add(surnameLabel);
        frame.add(surnameField);

        addressLabel.setBounds(50, 210, 75, 25);
        addressField.setBounds(200, 210, 200, 25);
        frame.add(addressLabel);
        frame.add(addressField);

        contactNumberLabel.setBounds(50, 250, 150, 25);
        contactNumberField.setBounds(200, 250, 200, 25);
        frame.add(contactNumberLabel);
        frame.add(contactNumberField);

        messageLabel.setBounds(130, 10, 250, 35);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 28));
        frame.add(messageLabel);

        signUpButton.setBounds(170, 300, 120, 35);
        signUpButton.setFocusable(false);
        signUpButton.addActionListener(this);
        signUpButton.setBackground(new Color(83, 186, 224));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(signUpButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {

            // assigning inputs to variables
            String customerID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            String name = nameField.getText();
            String surName = surnameField.getText();
            String address = addressField.getText();
            String contactNumber = contactNumberField.getText();

            // controlling inputs with regex
            if (!customerID.matches("\\d{4}")) {
                JOptionPane.showMessageDialog(null, "User ID must be a 4-digit number!", "", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (bank.containsKey(customerID)) {
                JOptionPane.showMessageDialog(null, "User ID already exists!", "", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!name.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name can only contain letters!", "", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!surName.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Surname can only contain letters!", "", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!contactNumber.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Contact number can only contain digits!", "",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // creating a new user with entered information
            Customer newUser = new Customer(customerID, password, name, surName, address, contactNumber);
            // putting created user in bank
            bank.put(customerID, newUser);
            JOptionPane.showMessageDialog(null, "Account created successfully!", "", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        }
    }

    public HashMap<String, Customer> getBank() {
        return bank;
    }
}