package Sample.ThreadCoordinate.conditionsample;

public class DrawTest
{
	public static void main(String[] args) 
	{
		// 创建一个账户
		Account acct = new Account("1234567" , 0);
		new DrawThread("Withdrawer" , acct , 800).start();
		new DepositThread("Depositer A" , acct , 800).start();
		new DepositThread("Depositer B" , acct , 800).start();
		new DepositThread("Depositer C" , acct , 800).start();
	}
}
