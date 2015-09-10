package Sample.ThreadRunnableCallable;


public class ThreadSample extends java.lang.Thread
{
	private int i ;
	public void run()
	{
		for ( ; i < 100 ; i++ )
		{
			System.out.println(getName() +  " " + i);
		}
	}
	public static void main(String[] args) 
	{
		for (int i = 0; i < 100;  i++)
		{
			System.out.println(java.lang.Thread.currentThread().getName()
				+  " " + i);
			if (i == 20)
			{
				new ThreadSample().start();
				new ThreadSample().start();
			}
		}
	}
}

