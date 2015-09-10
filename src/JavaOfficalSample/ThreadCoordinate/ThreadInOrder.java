package JavaOfficalSample.ThreadCoordinate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadInOrder {

    public static void main(String[] args) throws InterruptedException {

        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        ThreadPrinter printerA = new ThreadPrinter("A", c, a);
        ThreadPrinter printerB = new ThreadPrinter("B", a, b);
        ThreadPrinter printerC = new ThreadPrinter("C", b, c);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(printerA);
        //Ensure ThreadSample is launch in order
        Thread.sleep(10);
        executor.execute(printerB);
        //Ensure ThreadSample is launch in order
        Thread.sleep(10);
        executor.execute(printerC);

        executor.awaitTermination(2, TimeUnit.SECONDS);
        executor.shutdownNow();
    }

}

class ThreadPrinter implements Runnable{

    private String name;
    private Object pre;
    private Object self;

    public ThreadPrinter(String name, Object pre, Object self) {
        this.name = name;
        this.pre = pre;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0){
            //Hold previous object's lock
            synchronized (pre){
                //Hold current object's lock
                synchronized (self){
                    System.out.print(name);
                    count--;
                    //Release current object's lock, tell other threads which is waiting for current object to unlock
                    self.notify();
                }
                //Release previous object's lock
                try {
                    pre.wait(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
