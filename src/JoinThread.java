/**
 * Created by kerua on 7/7/2015.
 */
public class JoinThread {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        new Thread(new OneThread()).start();
    }
}

class OneThread implements Runnable{
    @Override
    public void run() {
        System.out.println("1st thread is running");
        Thread anotherThread = new Thread(new AnotherThread());
        anotherThread.start();
        try {
            anotherThread.join();
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("1st thread is end");
    }
}

class AnotherThread implements Runnable{
    @Override
    public void run() {
        System.out.println("2nd thread is running");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("2nd thread is end");
    }
}
