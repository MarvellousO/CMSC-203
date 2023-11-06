package bank;

public class CheckingAccount extends BankAccount {
    // Static constant for the fee for check clearing
    private static final double FEE = 0.15;

    // Constructor that takes a name and an initial amount
    public CheckingAccount(String name, double initialAmount) {
        super(name, initialAmount); // Call the superclass constructor

        // Initialize accountNumber as the original accountNumber concatenated with "-10"
        setAccountNumber(getAccountNumber() + "-10");
    }

    // Override the withdraw method
    public boolean withdraw(double amount) {
        // Calculate the total withdrawal amount with the check clearing fee
        double totalWithdrawalAmount = amount + FEE;

        // Call the withdraw method from the superclass
        boolean withdrawalSuccessful = super.withdraw(totalWithdrawalAmount);

        // Return the result obtained from the superclass withdraw method
        return withdrawalSuccessful;
    }
}

