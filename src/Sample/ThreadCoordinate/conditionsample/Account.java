package Sample.ThreadCoordinate.conditionsample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account
{
	private final Lock lock = new ReentrantLock();

	private final Condition cond  = lock.newCondition();

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

    public void draw(double drawAmount)
	{
		lock.lock();
		try
		{
			if (!flag)
			{
                cond.await();
			}
			else
			{
				System.out.println(Thread.currentThread().getName()
					+ " draw :" +  drawAmount);
				balance -= drawAmount;
				System.out.println("Balance is : " + balance);
				flag = false;
				cond.signalAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
	}
	public void deposit(double depositAmount)
	{
		lock.lock();
		try
		{
			if (flag)
			{
                cond.await();
			}
			else
			{
				System.out.println(Thread.currentThread().getName()
					+ " deposit :" +  depositAmount);
				balance += depositAmount;
				System.out.println("Balance is : " + balance);
				flag = true;
				cond.signalAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			lock.unlock();
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