package Sample.ThreadCoordinate.synchronizedsample;

public class DrawTest
{
	public static void main(String[] args) 
	{
		Account acct = new Account("1234567" , 0);
		new DrawThread("Withdrawer" , acct , 800).start();
		new DepositThread("Depositor A" , acct , 800).start();
		new DepositThread("Depositor B" , acct , 800).start();
		new DepositThread("Depositor C" , acct , 800).start();
	}
}
