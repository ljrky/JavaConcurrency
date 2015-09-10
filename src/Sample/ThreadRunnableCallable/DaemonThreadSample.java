package Sample.ThreadRunnableCallable;

public class DaemonThreadSample extends Thread
{
	public void run()
	{
		for (int i = 0; i < 1000 ; i++ )
		{
			System.out.println(getName() + "  " + i);
		}
	}
	public static void main(String[] args) 
	{
		DaemonThreadSample t = new DaemonThreadSample();
		t.setDaemon(true);
		t.start();
		for (int i = 0 ; i < 10 ; i++ )
		{
			System.out.println(Thread.currentThread().getName()
				+ "  " + i);
		}
	}
}
