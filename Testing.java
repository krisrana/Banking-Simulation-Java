import java.util.Random;


/**
 * @author krishna  Rana
 * Date: 6/21/2017
 * purpose: 
 */
public class Testing
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SavingsAccount[] sa = new SavingsAccount[5];
		int[] randomAmount = new int[30];
		Random random = new Random();
		//local declaration
		double bal, rate;
		int number = 0;
		//local initilization
		bal = 5.00;
		rate = 0.05;
		
		/**
		 * Populating intialal balance and rate for all the savings Account object
		 */
		for(int i = 0; i < sa.length; i++)
		{
			bal = random.nextInt(200);
			rate = random.nextInt(50);  rate /= 100;
			sa[i] = new SavingsAccount(bal ,rate);	
		}
	
		/**
		 * setting randomvalue till $1000 for an obeject 30 times.
		 * and setting those value randomly to deposit or withdraw.
		 */
		for(int i = 0; i < sa.length; i++)
		{	
			for(int j = 0; j < randomAmount.length; j++)
			{
				int bound = random.nextInt(2);
				randomAmount[j] = random.nextInt(1000);
				number = randomAmount[j];
				
				if(bound == 0)
					sa[i].deposit(number);
				else
					sa[i].withdraw(number);
			}			
		}
		
		
		/**
		 * prints all transaction for number of object created with array.
		 */
		for(int i = 0; i < sa.length; i++)
		{
			System.out.println(sa[i].toString());
			sa[i].monthlyProcess();
			System.out.println("\nTRANSACTION AFTER MONTHLY PROCESS");
			System.out.println(sa[i].toString());
			System.out.println("\nEND OF TRANSACTION");

			
		}
	}
}
