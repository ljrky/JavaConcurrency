package Sample.ThreadCoordinate.blockingqueuesample;

import java.util.concurrent.*;

public class BlockingQueueSample
{
	public static void main(String[] args)
		throws Exception
	{
        System.out.println("Get a blocking queue with size 2");
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);

        System.out.println("Putting one element");
		bq.put("Java");

        System.out.println("Putting one element");
		bq.put("Java");

        System.out.println("Putting one element");
		bq.put("Java");
	}
}
