package Sample.ThreadPool;

import java.util.concurrent.*;

class MyThread implements Runnable
{
	public void run()
	{
		for (int i = 0; i < 100 ; i++ )
		{
			System.out.println(Thread.currentThread().getName()
				+ "i is :" + i);
		}
	}
}
public class FixedThreadPoolSample
{
	public static void main(String[] args) 
		throws Exception
	{
		ExecutorService pool = Executors.newFixedThreadPool(6);
		pool.submit(new MyThread());
		pool.submit(new MyThread());
		pool.shutdown();
	}
}

