package Sample.ThreadEmbeddedMethod;

public class YieldMethod extends Thread
{
	public YieldMethod(String name)
	{
		super(name);
	}
	public void run()
	{
		for (int i = 0; i < 50 ; i++ )
		{
			System.out.println(getName() + "  " + i);
			if (i == 20)
			{
				Thread.yield();
			}
		}
	}
	public static void main(String[] args)throws Exception
	{
		YieldMethod yt1 = new YieldMethod("High Priority");
		yt1.setPriority(Thread.MAX_PRIORITY);
		yt1.start();
		YieldMethod yt2 = new YieldMethod("Low Priority");
		yt2.setPriority(Thread.MIN_PRIORITY);
		yt2.start();
	}
}
