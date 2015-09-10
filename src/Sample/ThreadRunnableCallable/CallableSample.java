package Sample.ThreadRunnableCallable;

import java.util.concurrent.*;


public class CallableSample implements Callable<Integer>
{
	public Integer call()
	{
		int i = 0;
		for ( ; i < 100 ; i++ )
		{
			System.out.println(ThreadSample.currentThread().getName()
				+ i);
		}
		return i;
	}

	public static void main(String[] args) 
	{
		CallableSample rt = new CallableSample();
		FutureTask<Integer> task = new FutureTask<>(rt);
		for (int i = 0 ; i < 100 ; i++)
		{
			System.out.println(ThreadSample.currentThread().getName()
				+ i);
			if (i == 20)
			{
				new Thread(task).start();
			}
		}
		try
		{
			System.out.println(task.get());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

