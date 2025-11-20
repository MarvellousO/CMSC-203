public class CheckingAccount extends BankAccount {

	static final double FEE = 0.15;

	public CheckingAccount(String name, double amount){
		super(name, amount);
		String accountNumber = super.getAccountNumber()+"-"+"10";
		super.setAccountNumber(accountNumber);
	}

	@Override
	public boolean withdraw(double amount){
		boolean withdrawEnabled = true;
		
		if(amount > super.getBalance() ){
			return withdrawEnabled;
		}
		else
		{  withdrawEnabled  = false;
			return withdrawEnabled;
		}

	}

}
