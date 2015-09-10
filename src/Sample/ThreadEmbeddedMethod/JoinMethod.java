package Sample.ThreadEmbeddedMethod;

public class JoinMethod extends Thread
{
	public JoinMethod(String name)
	{
		super(name);
	}
	public void run()
	{
		for (int i = 0; i < 100 ; i++ )
		{
			System.out.println(getName() + "  " + i);
		}
	}
	public static void main(String[] args)throws Exception
	{
		new JoinMethod("New Thread!").start();
		for (int i = 0; i < 100 ; i++ )
		{
			if (i == 20)
			{
				JoinMethod jt = new JoinMethod("Joined Thread");
				jt.start();
				jt.join();
			}
			System.out.println(Thread.currentThread().getName()
				+ "  " + i);
		}
	}
}
