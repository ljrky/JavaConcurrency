package Sample.ThreadEmbeddedMethod;

public class PriorityMethod extends Thread
{
	public PriorityMethod(String name)
	{
		super(name);
	}
	public void run()
	{
		for (int i = 0 ; i < 50 ; i++ )
		{
			System.out.println(getName() +  ", Priority is : "
				+ getPriority() + ", i : " + i);
		}
	}
	public static void main(String[] args) 
	{
		Thread.currentThread().setPriority(6);
		for (int i = 0 ; i < 30 ; i++ )
		{
			if (i == 10)
			{
				PriorityMethod low  = new PriorityMethod("low priority thread");
				low.start();
				System.out.println(", Priority is : "
					+ low.getPriority());
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if (i == 20)
			{
				PriorityMethod high = new PriorityMethod("high priority thread");
				high.start();
				System.out.println(", Priority is : "
					+ high.getPriority());
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}
}
