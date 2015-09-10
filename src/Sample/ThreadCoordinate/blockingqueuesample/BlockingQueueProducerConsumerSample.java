package Sample.ThreadCoordinate.blockingqueuesample;

import java.util.concurrent.*;

class Producer extends Thread
{
	private BlockingQueue<String> bq;
	public Producer(BlockingQueue<String> bq)
	{
		this.bq = bq;
	}
	public void run()
	{
		String[] strArr = new String[]
		{
			"Java",
			"Struts",
			"Spring"
		};
		for (int i = 0 ; i < 9 ; i++ )
		{
			System.out.println(getName() + "Producer putting element into queue!");
			try
			{
				Thread.sleep(200);
				bq.put(strArr[i % 3]);
			}
			catch (Exception ex){ex.printStackTrace();}
			System.out.println(getName() + "Producer done his job" + bq);
		}
	}
}
class Consumer extends Thread
{
	private BlockingQueue<String> bq;
	public Consumer(BlockingQueue<String> bq)
	{
		this.bq = bq;
	}
	public void run()
	{
		while(true)
		{
			System.out.println(getName() + "Consumer taking element out of queue!");
			try
			{
				Thread.sleep(200);
				bq.take();
			}
			catch (Exception ex){ex.printStackTrace();}
			System.out.println(getName() + "Consumer done his job" + bq);
		}
	}
}
public class BlockingQueueProducerConsumerSample
{
	public static void main(String[] args)
	{
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
		new Consumer(bq).start();
	}
}