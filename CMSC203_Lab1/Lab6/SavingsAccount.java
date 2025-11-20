public class SavingsAccount extends BankAccount{

	private double rate = 0.025;
	private int  savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double amount)
	{
		super(name, amount);
		this.accountNumber = super.getAccountNumber()+
							"-" +
							this.savingsNumber;

	}
	@Override
	 public String getAccountNumber(){return accountNumber;}
	
	
	 public void postInterest()
	 { double oneMonthInterest = getBalance() * (rate/12);
	 super.deposit(oneMonthInterest);
	 
	 }

	 public SavingsAccount(SavingsAccount oldAccount, double amount){
		 super(oldAccount,amount);
		 savingsNumber = oldAccount.savingsNumber++;
		 this.accountNumber = super.getAccountNumber() +"-"+ savingsNumber;
	 }

}
