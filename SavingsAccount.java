/**
 * @author krishna  Rana
 * Date: 6/21/2017
 * purpose: This class extends the BankAccount class. which contain a boolean status.
 *  		it inherits BankAccount class. the status is used to make account active or
 *  		inactive based on the balance. if the balance falls below $20 then the account is
 *  		set as inactive. it also has 3 methods which overides the deposit, withdraw and
 *  		monthlyprocess method from BankAccount class.
 */
public class SavingsAccount extends BankAccount
{
	//local declarations
	private boolean status;
	
	/**
	 * Constructor which passes the correct parameter to the super class
	 */
	public SavingsAccount(double balance, double yearlyInterest)
	{
		//initalize super construtor
		super(balance, yearlyInterest);
		
		//account to set active
		if(balance >= 20)
			setStatus(true);
		//account set to inactive
		else
			setStatus(false);		
	}
	
	/**
	 * withdraw() method checks if account is active or inactive
	 * if the account is active it calls the superclass withdraw()
	 */
	public void withdraw(double amount)
	{
		if(isStatus())
		{
			super.withdraw(amount);
			if(super.getBalance() < 20)
				setStatus(false);
		}
	}
	
	/**
	 * deposit() method check if account is active or inactive.
	 * if the account is inactive it see if the amount to be deposited makes the 
	 * account active or not. if it makes the account active than it will add the amount
	 * calling superclass deposit method and set account status active.
	 */
	public void deposit(double amount)
	{
		if(!isStatus())
		{
			double availableBalance = super.getBalance() + amount;
			if(availableBalance >= 20)
				setStatus(true);
		}
		super.deposit(amount);
	}
	
	/**
	 * monthlyProcess() method check the number of withdrawals. if the withdrawals
	 * are more than 5 a month it will charge $2 service charge for each withdrawals
	 * above 5 and also checks if the balance falls under $20, the status is set to be inactive.
	 */
	public void monthlyProcess()
	{
		int withdrawCounter = super.getNumberOfWithdrawals();
		
		if(withdrawCounter > 5)
		{
			super.setServiceCharge((withdrawCounter - 5) * 2);
			
			super.monthlyProcess();
			super.getserviceCharge();
			if(super.getBalance() < 20)
				setStatus(false);
		}
	}
	
	/**
	 * toString() displays results from superclass toString method
	 * and also add extra message on account status
	 */
	public String toString()
	{
		String message, accountStatus;
		
		if(status == true)
			accountStatus = "Active";
		else
			accountStatus = "Inactive";
		
		message = "\nAccount Status: " + accountStatus;
		
		return super.toString() + message;
	}
	
	//Accessor and Mutator methods
	/**
	 * @return the status
	 */
	public boolean isStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status)
	{
		this.status = status;
	}
	

}
