package Sample.SynchronizedAndLock.synchronizedMethod;

public class Account
{
	private String accountNo;
	private double balance;

    public Account(String accountNo , double balance)
	{
		this.accountNo = accountNo;
		this.balance = balance;
	}

    public String getAccountNo()
	{
		return this.accountNo;
	}


	public synchronized void draw(double drawAmount)
	{

		if (balance >= drawAmount)
		{

			System.out.println(Thread.currentThread().getName()
				+ " draw : " + drawAmount);
			try
			{
				Thread.sleep(1);
			}
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
			balance -= drawAmount;
			System.out.println("Account balance is : " + balance);
		}
		else
		{
			System.out.println(Thread.currentThread().getName()
				+ " is out of balance");
		}
	}


	public int hashCode()
	{
		return accountNo.hashCode();
	}
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if (obj !=null
			&& obj.getClass() == Account.class)
		{
			Account target = (Account)obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}
}