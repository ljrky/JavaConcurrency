package JavaOfficalSample.LowLevelThead;

public class RunnableAndThread {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        new Thread(new HelloWorldRunner()).start();
        new HelloWorldThread().start();
    }
}

class HelloWorldRunner implements Runnable{
    @Override
    public void run() {
        System.out.println("HelloWorld Runner");
    }
}

class HelloWorldThread extends Thread{
    @Override
    public void run() {
        System.out.println("HelloWorld ThreadSample");
    }
}
