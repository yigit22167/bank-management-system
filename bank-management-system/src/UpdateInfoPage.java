import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class UpdateInfoPage implements ActionListener {

    // frame elements
    private JFrame frame;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField addressField;
    private JTextField contactNumberField;
    private JButton updateButton;
    private JPanel rightPanel;

    // customer and bank
    private Customer currentCustomer;
    private HashMap<String, Customer> bank;

    public UpdateInfoPage(Customer currentCustomer, HashMap<String, Customer> bank, JPanel rightPanel) {
        this.currentCustomer = currentCustomer;
        this.bank = bank;
        this.rightPanel = rightPanel;

        // setting up frame
        frame = new JFrame("Update Info");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));
        frame.setLocationRelativeTo(null);

        // adding labels and button to the frame
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(currentCustomer.getName());
        frame.add(nameLabel);
        frame.add(nameField);

        JLabel surnameLabel = new JLabel("Surname:");
        surnameField = new JTextField(currentCustomer.getSurName());
        frame.add(surnameLabel);
        frame.add(surnameField);

        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField(currentCustomer.getAddress());
        frame.add(addressLabel);
        frame.add(addressField);

        JLabel contactNumberLabel = new JLabel("Contact Number:");
        contactNumberField = new JTextField(currentCustomer.getContactNumber());
        frame.add(contactNumberLabel);
        frame.add(contactNumberField);

        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        frame.add(updateButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateButton) {
            String newName = nameField.getText();
            String newSurname = surnameField.getText();
            String newAddress = addressField.getText();
            String newContactNumber = contactNumberField.getText();

            // set updated info to customer object
            currentCustomer.setName(newName);
            currentCustomer.setSurName(newSurname);
            currentCustomer.setAddress(newAddress);
            currentCustomer.setContactNumber(newContactNumber);

            // put updated customer with new info to bank
            bank.put(currentCustomer.getCustomerID(), currentCustomer);

            // update right panel
            updateRightPanel();

            JOptionPane.showMessageDialog(null, "Information updated successfully!",
                    "Update Info", JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
        }
    }

    private void updateRightPanel() {

        // updating shown info with new info
        rightPanel.removeAll();
        rightPanel.setLayout(new GridLayout(6, 1));
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

        rightPanel.revalidate();
        rightPanel.repaint();
    }
}