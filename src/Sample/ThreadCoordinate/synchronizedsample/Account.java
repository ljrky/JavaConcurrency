package Sample.ThreadCoordinate.synchronizedsample;

public class Account
{
	private String accountNo;
	private double balance;

	private boolean flag = false;

	public Account(){}

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
		try
		{
			if (!flag)
			{
				wait();
			}
			else
			{
				System.out.println(Thread.currentThread().getName()
					+ " withdraw:" +  drawAmount);
				balance -= drawAmount;
				System.out.println("Balance is : " + balance);
				flag = false;
				notifyAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
	public synchronized void deposit(double depositAmount)
	{
		try
		{
			if (flag)
			{
				wait();
			}
			else
			{
				System.out.println(Thread.currentThread().getName()
					+ " Deposit" +  depositAmount);
				balance += depositAmount;
				System.out.println("Balance is : " + balance);
				flag = true;
				notifyAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
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