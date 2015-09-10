package Sample.ThreadRunnableCallable;


public class RunnableSample implements Runnable
{
	private int i ;
	public void run()
	{
		for ( ; i < 100 ; i++ )
		{
			System.out.println(ThreadSample.currentThread().getName()
				+ "  " + i);
		}
	}
		
	public static void main(String[] args) 
	{
		for (int i = 0; i < 100;  i++)
		{
			System.out.println(ThreadSample.currentThread().getName()
				+ "  " + i);
			if (i == 20)
			{
				RunnableSample st = new RunnableSample();
				new Thread(st).start();
				new Thread(st).start();
			}
		}
	}
}

