package Sample.ThreadEmbeddedMethod;

import java.util.*;

public class SleepMethod
{
	public static void main(String[] args)
		throws Exception
	{
		for (int i = 0; i < 10 ; i++ )
		{
			System.out.println(new Date());
			Thread.sleep(1000);
		}
	}
}

