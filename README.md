# Bank Management System

This project is a Java-based banking application with a graphical user interface (GUI) that supports various functionalities such as account management, transactions, balance inquiries, and currency exchange. It uses a HashMap to store customer information and Swing for the GUI components.

# Features

Account Management: Create deposit, saving, and currency accounts.

Transactions: Perform deposits, withdrawals, and money transfers.

Balance Inquiries: Check account balances.

Currency Exchange: Convert account balance to different currencies.

# Class Descriptions

## Customer.java
The Customer class represents individual customers of the bank. Each customer has unique attributes such as `customerID`, `password`, `name`, `surname`, `address`, and `contactNumber`. Additionally, a `Customer` object maintains a collection of accounts associated with that customer through a `Map<Integer, Account>`, which allows easy access to all accounts owned by a particular customer. This map is initialized by the constructor.

- **transferMoney(Customer receiver, double amount)**: Enables a customer to transfer a specified amount of money to another customer. The transfer is only possible if the sender has sufficient funds in their account. This method is used inside `TransferMoneyPage.java`.

## Bank.java
The Bank class manages customer data using a `HashMap<String, Customer>`, where each entry is keyed by the customer's unique `customerID`. This structure facilitates efficient retrieval and manipulation of customer information.

## Account.java
The `Account` class is an abstract superclass that defines common methods and attributes shared by `DepositAccount`, `CurrencyAccount`, and `SavingAccount`. It includes methods for depositing and withdrawing funds and accessing and modifying attributes like balance and currencyUnit.

- **deposit(double amount)**: Adds the specified amount to the account's balance.

- **withdraw(double amount)**: Subtracts the specified amount from the account's balance. 

These methods are called inside `DepositWithdrawPage.java`.
## CurrencyAccount.java

The `CurrencyAccount` class extends `Account`. Its constructor calls the superclass constructor and sets the `accountType` to 3. A `HashMap<String, Double>` for exchange rates is initialized.

- **exchangeCurrency(String fromCurrency, String toCurrency, double amount)**: Exchanges currency units based on the provided exchange rates. This method is used in `ExchangeCurrencyPage.java`.

# GUI Components
The application uses various Swing components to create its GUI:

- **SignUpPage.java**: Contains Swing elements for creating a user account and validates user input.
- **LoginPage.java**: Initializes the bank HashMap and handles the login process, checking if the entered `customerID` and `password` exist in the bank.
- **CreateAccountPage.java**: Allows users to create different types of accounts (deposit, saving, currency) using radio buttons and buttons.
- **DepositWithdrawPage.java**: Facilitates deposit and withdrawal operations by prompting the user to select an account and enter an amount.
- **TransferMoneyPage.java**: Allows users to transfer money to another account by entering the recipient's ID.
- **ExchangeCurrencyPage.java**: Handles currency exchange operations, converting the account balance to a specified unit.
- **ShowBalancePage.java**: Displays the user's account information.
- **UpdateInfoPage.java**: Provides input fields and buttons for updating user information such as name, surname, address, and contact number.
- **MainPage.java**: The main interface of the application with buttons for all major operations and a logout button that returns to the login page.

# Libraries and Elements Used
- javax.swing
- java.awt
- java.awt.event.ActionEvent
- java.awt.event.ActionListener
- java.awt.Color
- java.awt.Font
- javax.swing.JButton
- javax.swing.JFrame
- javax.swing.JLabel
- javax.swing.JOptionPane
- javax.swing.JPasswordField
- javax.swing.JTextField

## How to Run
1. Clone the repository.

2. Open the project in your preferred Java IDE.

3. -Run the `Test.java` to start the application.
