package Sample.SynchronizedAndLockAndThreadLocal.ThreadLocal;


class Account
{
	private ThreadLocal<String> name = new ThreadLocal<>();

	public Account(String str)
	{
		this.name.set(str);

		System.out.println("---" + this.name.get());
	}

	public String getName()
	{
		return this.name.get();
	}
	public void setName(String str)
	{
		this.name.set(str);
	}
}
class MyTest extends Thread
{

	private Account account;
	public MyTest(Account account, String name)
	{
		super(name);
		this.account = account;
	}
	public void run()
	{

		for (int i = 0 ; i < 10 ; i++)
		{

			if (i == 6)
			{
				account.setName(getName());
			}

			System.out.println(account.getName()
				+ " account's i is : " + i);
		}
	}
}
public class ThreadLocalSample
{
	public static void main(String[] args) 
	{
		Account at = new Account("Original Account");

		new MyTest(at , "Thread A").start();
		new MyTest(at , "Thread B").start ();
	}
}
