package bank;

public class SavingsAccount extends BankAccount {
    private double rate; // Instance variable for the annual interest rate
    private int savingsNumber; // Instance variable to track the number of savings accounts
    private String accountNumber; // Instance variable to hide the superclass accountNumber

    // Constructor that takes a name and an initial balance
    public SavingsAccount(String name, double initialBalance) {
        super(name, initialBalance); // Call the superclass constructor
        rate = 0.025; // Set the annual interest rate to 2.5%
        savingsNumber = 0; // Initialize the savings account number to 0

        // Initialize accountNumber by concatenating the superclass accountNumber with a hyphen and savingsNumber
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    // Additional methods specific to savings accounts (if needed)

    // Method to create a new savings account with an incremented number
    public void createSavingsAccount() {
        savingsNumber++;
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    // Method to calculate and deposit one month's worth of interest
    public void postInterest() {
        double balance = getBalance(); // Get the current balance
        double monthlyInterest = balance * (rate / 12); // Calculate monthly interest
        deposit(monthlyInterest); // Deposit the monthly interest into the account
    }

    // Override the getAccountNumber method
    @Override
    public String getAccountNumber() {
        return accountNumber; // Provide your own implementation for accountNumber
    }

    // Copy constructor that creates another savings account for the same person
    public SavingsAccount(SavingsAccount oldAccount, double initialBalance) {
        super(oldAccount, initialBalance); // Call the superclass copy constructor
        savingsNumber = oldAccount.savingsNumber + 1; // Increment the savingsNumber
        accountNumber = super.getAccountNumber() + "-" + savingsNumber; // Create a unique account number
    }
}