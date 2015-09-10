package Sample.ThreadRunnableCallable;


class MyThread extends Thread
{
	public MyThread(String name)
	{
		super(name);
	}

	public MyThread(ThreadGroup group , String name)
	{
		super(group, name);
	}
	public void run()
	{
		for (int i = 0; i < 20 ; i++ )
		{
			System.out.println(getName() + " i is : " + i);
		}
	}
}
public class ThreadGroupSample
{
	public static void main(String[] args) 
	{
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("Main Thread Group Name : "
			+ mainGroup.getName());
		System.out.println("Is Main Thread Group Daemon"
			+ mainGroup.isDaemon());
		new MyThread("Thread from Main Thread Group").start();
		ThreadGroup tg = new ThreadGroup("New Thread Group tg");
		tg.setDaemon(true);
		System.out.println("Is New tg Thread Group Daemon"
			+ tg.isDaemon());
		MyThread tt = new MyThread(tg , "tg Thread Group's Thread A");
		tt.start();
		new MyThread(tg , "tg Thread Group's Thread B").start();
	}
}

