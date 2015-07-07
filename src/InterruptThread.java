import java.io.InterruptedIOException;

/**
 * Created by kerua on 7/7/2015.
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread Static Functions");

        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (int i = 0; i < importantInfo.length; i++) {
            System.out.println("Thread is sleeping");
            Thread.sleep(4000);
            System.out.println(importantInfo[i]);
        }
        Thread InterruptedThread = new Thread(new InterrupteThread());
        InterruptedThread.start();
        System.out.println("Thread status is : " + InterruptedThread.isInterrupted());
        InterruptedThread.interrupt();

//        Thread InterruptedByOtherThread = new Thread(new InterruptedByOthers());
//        InterruptedByOtherThread.start();
//        System.out.println("Thread status is : " + InterruptedByOtherThread.isInterrupted());
//        InterruptedByOtherThread.interrupt();
//        System.out.println("Thread status is : " + InterruptedByOtherThread.isInterrupted());

//        Thread ThrowInterruptedExceptionThead = new Thread(new InterruptedThrowException());
//        ThrowInterruptedExceptionThead.start();
//        ThrowInterruptedExceptionThead.interrupt();
    }
}

class InterrupteThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                return;
            }
        }
    }
}

class InterruptedByOthers implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            if(Thread.interrupted()){
                System.out.println("thread interrupted by others");
            }
        }
    }
}

class InterruptedThrowException extends Thread {
    @Override
    public void run() {
        if (Thread.interrupted()) {
            System.out.println("Throw exception!");
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}