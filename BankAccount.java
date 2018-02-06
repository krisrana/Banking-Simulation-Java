/**
 * @author krishna  Rana
 * Date: 6/21/2017
 * purpose: This class is an abstract class. it contains a constructor
 * 			with 2 parameters, four method which will handle the deposit
 * 			withdraw, interest calculation and monthly processes for an 
 * 			account. it also has accessor and mutator functions.
 */
public abstract class BankAccount
{
	//local declarations
	private double balance;
	private int numberOfDeposits;
	private int numberOfWithdrawals;
	private double yearlyInterest;
	private double serviceCharge;
	
	/**
	 * Constructor which takes 2 arguments
	 * which initializes balance and yearly interest rate
	 * @param balance
	 * @param yearlyInterest
	 */
	public BankAccount(double balance, double yearlyInterest)
	{
		this.balance = balance;
		this.yearlyInterest = yearlyInterest;
		this.setNumberOfDeposits(0);
		this.setNumberOfWithdrawals(0);
		this.serviceCharge = 0;
	}
	
	/**
	 * deposit() that accepts an argument for deposit
	 * and add the amount to the available balance
	 * and also increments the number of deposits.
	 * @param amount
	 */
	public void deposit(double amount)
	{
		balance += amount;
		setNumberOfDeposits(getNumberOfDeposits() + 1);
	}
	
	/**
	 * withdraw() that accepts an argument to withdraw
	 * and deducts the amount from the avaiable balance
	 * and also increments the number of withdrawals
	 * @param amount
	 */
	public void withdraw(double amount)
	{
		balance -= amount;
		setNumberOfWithdrawals(getNumberOfWithdrawals() + 1);
	}
	
	/**
	 * calcInterest() that calculates the monthly interest from balance
	 *  and add the interest to the balance
	 */
	public void calcInterest()
	{
		double monthlyInterestRate, monthlyInterest;
		
		//finds the monthly interest rate
		monthlyInterestRate = (yearlyInterest / 12);
		//finds the monthly interest
		monthlyInterest = balance * monthlyInterestRate;
		//updates the balance by calulating interest
		balance += monthlyInterest;		
	}
	
	/**
	 * monthlyProcess() subtracts the monthly service charge from the balance
	 * and updates the balance by calling calcInterest() and sets the
	 * number of deposits, withdrawals and service charge to zero.
	 */
	public void monthlyProcess()
	{
		balance -= serviceCharge;
		calcInterest();
		setNumberOfDeposits(0);
		setNumberOfWithdrawals(0);
		serviceCharge = 0;
	}
	
	/**
	 * toString() returns the string which contains the information
	 * of balance, deposits, withdrawals interest rate and service charge.
	 */
	public String toString()
	{
		String message;
		
		message = "\n**********TRANSACTION RECIPT**********"
				+ "\n------------------------------------"
				+ "\nBalance: " + balance
				+ "\nNumber of Deposits: " + numberOfDeposits
				+ "\nNumber of Withdrawals: " + numberOfWithdrawals
				+ "\nAnnual interest rate: " + yearlyInterest * 100 + "%" 
				+ "\nMonthly service charge: " + serviceCharge;
				
		return message;
	}
	
	//Mutator method
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	/**
	 * @param numberOfDeposits the numberOfDeposits to set
	 */
	public void setNumberOfDeposits(int numberOfDeposits)
	{
		this.numberOfDeposits = numberOfDeposits;
	}
	
	/**
	 * @param numberOfWithdrawals the numberOfWithdrawals to set
	 */
	public void setNumberOfWithdrawals(int numberOfWithdrawals)
	{
		this.numberOfWithdrawals = numberOfWithdrawals;
	}
	
	/**
	 * @param serviceCharge the serviceCharge to set
	 */
	public void setServiceCharge(double serviceCharge)
	{
		this.serviceCharge = serviceCharge;
	}
	
	//Accessor method
	/**
	 * @return the balance
	 */
	public double getBalance()
	{
		return numberOfDeposits;
	}	
	
	/**
	 * @return the numberOfDeposits
	 */
	public int getNumberOfDeposits()
	{
		return numberOfDeposits;
	}

	/**
	 * @return the numberOfWithdrawals
	 */
	public int getNumberOfWithdrawals()
	{
		return numberOfWithdrawals;
	}
	
	/**
	 * @return the serviceCharge
	 */
	public double getserviceCharge()
	{
		return serviceCharge;
	}
}
