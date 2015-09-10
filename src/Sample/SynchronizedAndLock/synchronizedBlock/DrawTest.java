package Sample.SynchronizedAndLock.synchronizedBlock;

public class DrawTest
{
	public static void main(String[] args) 
	{
		Account acct = new Account("1234567" , 1000);
		System.out.println("Account has : 1000");

		new DrawThread("Thread A" , acct , 800).start();
		new DrawThread("Thread B" , acct , 800).start();
	}
}

